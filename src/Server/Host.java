package Server;

import Code.Security;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import loader.MemberLoader;
import model.User;

/**
 *
 * @author reece
 */
public class Host {

    int port;
    Clients client = new Clients();

    Security sec = new Security();

    public Host(int port) {
        client.initialise();
        this.port = port;
    }

    public void start() throws Exception {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started on port: " + port);
        sec.saveLog("This server is activated. Port #: " + port);

        while (!Thread.interrupted()) {
            System.out.println("Waiting for client...");
            sec.saveLog("Server started, waiting for client...");
            Socket clientSocket = server.accept();
            sec.saveLog("Client Connected!");
            PrintStream output = new PrintStream(clientSocket.getOutputStream());

            Thread t = new Thread() {

                private void sendKey() throws Exception {
                    //send file
                    sec.saveLog("Sending the key to the client now...");
                    File myFile = new File("C:\\RTC\\lockdown\\data.key");
                    if (!myFile.exists()) {
                        myFile.createNewFile();
                    }
                    byte[] mybytearray = new byte[(int) myFile.length()];
                    FileInputStream fis = new FileInputStream(myFile);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    bis.read(mybytearray, 0, mybytearray.length);
                    OutputStream os = clientSocket.getOutputStream();
                    System.out.println("Sending key (" + mybytearray.length + " bytes)");
                    sec.saveLog("Sending key (" + mybytearray.length + " bytes)");
                    os.write(mybytearray, 0, mybytearray.length);
                    os.flush();
                    System.out.println("Done.");
                    sec.saveLog("Done");
                }

                private void receiveFile(String folder, String fileName, int size) throws Exception {
                    //Receive the file.
                    System.out.println("Attempting to receive a file from the client machine... (" + size + " bytes)");
                    sec.saveLog("Attempting to receive a file from the client machine... (" + size + " bytes)");
                    byte[] mybytearray = new byte[size + 5];

                    //Tell the client to send the file
                    output.println("ready");
                    output.flush();
                    InputStream is = clientSocket.getInputStream();
                    System.out.println("Input stream is open, receiving file...");
                    sec.saveLog("Input stream is open, receiving file...");
                    FileOutputStream fos = new FileOutputStream("C:\\RTC\\" + folder + "\\" + fileName);

                    BufferedOutputStream bos = new BufferedOutputStream(fos);
                    int bytesRead = is.read(mybytearray, 0, mybytearray.length);
                    int current = bytesRead;

                    do {
                        bytesRead = is.read(mybytearray, current, (mybytearray.length - current));
                        if (bytesRead >= 0) {
                            current += bytesRead;
                        }
                        System.out.println("Downloading... " + bytesRead + " bytes of " + mybytearray.length);
                    } while (bytesRead > -1);
                    System.out.println("The file " + fileName + " was downloaded... Writing to file...");
                    bos.write(mybytearray, 0, current);
                    bos.flush();
                    bos.close();
                    is.close();
                }

                private String verifyUser(String user, String password) throws Exception {
                    MemberLoader members;
                    ArrayList<User> memberList = new ArrayList();
                    String[] membersList;
                    members = new MemberLoader();
                    //Decrypt members file
                    membersList = sec.decDetails("members");
                    //Load the members list
                    for (int i = 0; i < membersList.length; i++) {
                        memberList = members.loadMember(membersList[i]);
                    }
                    //Sort the data and look for a match.
                    Object[][] data = new Object[memberList.size()][5];
                    for (int i = 0; i < memberList.size(); i++) {
                        User member = memberList.get(i);
                        data[i][0] = member.getId();
                        data[i][1] = member.getPassword();
                        data[i][2] = member.getActive();
                        data[i][3] = member.getBalance();
                        data[i][4] = member.getName();
                        if (user.equals(data[i][0]) && password.equals(data[i][1])) {
                            if (Integer.parseInt(String.valueOf(data[i][2])) == 0) {
                                return "inactive";
                            } else {
                                sec.saveLog(member.getName() + " remotely signed in.");
                                return "active::" + data[i][0] + "::" + data[i][2] + "::" + data[i][3] + "::" + data[i][4];
                            }
                        }
                    }
                    return "Invalid";
                }

                @Override

                public void run() {
                    //Process once client at a time. If more than one, place in hold queue.
                    try {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        while (client.isServerActive()) {
                            output.println("Waiting for server to become available...");
                            Thread.sleep(5000);
                        }
                        //Once client connect, set server status to active.
                        client.serverActive(true);

                        System.out.println("Client connected successfully, asking what they want...");
                        output.println("request");
                        String response = reader.readLine();

                        if (response.equals("registerClient")) {
                            System.out.println("Client wishes to register. Getting client name...");
                            sec.saveLog("Client wishes to register. Getting client name...");
                            //Request the client name.
                            output.println("name");
                            String name = reader.readLine();
                            System.out.println(name + " is trying to register...");
                            sec.saveLog(name + " is trying to join this server...");

                            //Request the IP address of the client
                            System.out.println("Getting client IP...");
                            output.println("IP");
                            String IP = reader.readLine();
                            sec.saveLog(name + " is registering with the following IP address: " + IP);

                            //Add the client to the database
                            System.out.println("Registering client in database");
                            client.addClient(IP, name);
                            output.flush();

                            //Request authentication
                            System.out.println("Client awaiting verification...");
                            sec.saveLog("Waiting for " + name + " to authenticate...");
                            output.flush();
                            output.println("Authentication password: ");
                            String pass = reader.readLine();
                            if (pass.equals(sec.getAdminPassword())) {
                                System.out.println("Client Authenticated");
                                sec.saveLog(name + " has authenticated successfully.");
                                output.println("Registered");
                                sec.saveLog(name + " has successfully registered! Trying to send our key to them...");
                                sendKey();
                            } else {
                                System.out.println("Client did not authenticate, reverting changes...");
                                output.println("Incorrect password...");
                                sec.saveLog("AUTHENTICATION FAILED: " + IP + ": " + name);
                                client.initialise();
                            }

                            //Close the connection and set active ststus to false.
                            output.close();
                            reader.close();
                            client.serverActive(false);

                            //Wait before killing thread in case anything is pending...
                            Thread.sleep(500);
                        } else if (response.equals("login")) {
                            //User needs to sign in here
                            System.out.println("A user is signing in...");
                            String bytes = reader.readLine(); //<-- This should read the size of the file
                            sec.saveLog("A user is signing in...");
                            //Download the user info file from the client.
                            receiveFile("UserInfo", "signIn.dat", Integer.parseInt(bytes));
                            String userInfo[] = sec.decSLineFile("UserInfo", "signIn.dat").split("::");
                            System.out.println("Received info:\nUser: " + userInfo[0] + "\nPass: HIDDEN");
                            String valid = verifyUser(userInfo[0], userInfo[1]);
                            System.out.println("User: " + valid);
                            sec.saveLog(userInfo[0] + " is signing in. Details: " + valid);
                            output.println(valid);
                            sec.deleteTemp("UserInfo", "SignIn.dat");
                            output.flush();
                            output.close();
                            client.serverActive(false);
                        } //Add condition to update a user.

                    } catch (IOException | InterruptedException e) {
                        System.out.println(e);
                        sec.saveLog(String.valueOf(e));
                    } catch (Exception ex) {
                        Logger.getLogger(Host.class.getName()).log(Level.SEVERE, null, ex);
                        sec.saveLog(String.valueOf(ex));
                    }
                }
            };
            t.start();
        }
    }
}
