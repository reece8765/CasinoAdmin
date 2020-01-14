package GUI;

import Code.Details;
import Code.Global;
import Code.Security;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import loader.MemberLoader;
import loader.NotesLoader;
import model.Notes;
import model.User;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class UserAdminUI extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JMenuBar menuBar;
    private JMenu admin;
    private JMenu members;
    private JMenu notes;
    JTable bookTable;
    JTable memberTable;
    JTable notesTable;

    private JMenuItem adminAdd;
    private JMenuItem adminChngePwd;
    private JMenuItem adminExit;

    private JMenuItem memView;
    private JMenuItem memAdd;
    private JMenuItem memDel;
    private JMenuItem memEdit;
    private JMenuItem memBalance;
    private JMenuItem memWithdraw;
    private JMenuItem memSearch;

    private JMenuItem noteView;
    private JMenuItem noteAdd;
    private JMenuItem noteDel;
    private JMenuItem noteEdit;

    private final MemberLoader memberLoader = new MemberLoader();
    private ArrayList<User> memberList = new ArrayList<>();

    private final NotesLoader notesLoader = new NotesLoader();
    private ArrayList<Notes> notesList = new ArrayList<>();

    private final Security sec = new Security();

    private final String en = Security.encryption;

    /**
     *
     * @param user
     */
    public UserAdminUI(String user) {
        initialize();
        try {
            String[] membersList = sec.decDetails("members");
            for (int i = 0; i < membersList.length; i++) {
                memberList = memberLoader.loadMember(membersList[i]);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserAdminUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String[] noteList = sec.decDetails("notes");
            for (int i = 0; i < noteList.length; i++) {
                notesList = notesLoader.loadNotes(noteList[i]);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserAdminUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        displayMembers();
    }

    ;

    /**
     * Initialise the contents of the frame.
     */
    private void initialize() {
        //setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/icons/icon.JPG")));
        setTitle("User Management - " + Global.usrMgmtVersion);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        //adding admin menu and menu items
        admin = new JMenu("Admin");
        menuBar.add(admin);

        adminAdd = new JMenuItem("Add Member");
        adminChngePwd = new JMenuItem("Change Password");
        adminExit = new JMenuItem("Sign Out");
        admin.add(adminAdd);
        admin.add(adminChngePwd);
        admin.add(adminExit);
        adminAdd.addActionListener(this);
        adminChngePwd.addActionListener(this);
        adminExit.addActionListener(this);

        //adding members menu and menu items
        members = new JMenu("Members");
        menuBar.add(members);

        memView = new JMenuItem("View");
        memAdd = new JMenuItem("Add");
        memEdit = new JMenuItem("Edit Details");
        memBalance = new JMenuItem("Add Balance");
        memWithdraw = new JMenuItem("Withdraw Account Balance");
        memDel = new JMenuItem("Delete");
        memSearch = new JMenuItem("Search");

        members.add(memView);
        members.add(memAdd);
        members.add(memEdit);
        members.add(memBalance);
        members.add(memWithdraw);
        members.add(memDel);
        members.add(memSearch);

        memView.addActionListener(this);
        memAdd.addActionListener(this);
        memDel.addActionListener(this);
        memSearch.addActionListener(this);
        memEdit.addActionListener(this);
        memBalance.addActionListener(this);
        memWithdraw.addActionListener(this);

        notes = new JMenu("User Notes");
        menuBar.add(notes);
        noteView = new JMenuItem("View Notes");
        noteAdd = new JMenuItem("Add Note");
        noteDel = new JMenuItem("Delete Note");
        noteEdit = new JMenuItem("Edit Note");

        notes.add(noteView);
        notes.add(noteAdd);
        notes.add(noteEdit);
        notes.add(noteDel);
        noteView.addActionListener(this);
        noteAdd.addActionListener(this);
        noteEdit.addActionListener(this);
        noteDel.addActionListener(this);

        setSize(800, 500);
        setLocationRelativeTo(null);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == adminAdd) {
            new AddMember(this).setVisible(true);
        } else if (ae.getSource() == adminChngePwd) {
            new ChangePassword(1).setVisible(true);
        } else if (ae.getSource() == adminExit) {
            new LoginUI().setVisible(true);
            this.dispose();
        } else if (ae.getSource() == memView) {
            displayMembers();
        } else if (ae.getSource() == memAdd) {
            new AddMember(this).setVisible(true);
        } else if (ae.getSource() == memEdit) {
            int selected = memberTable.getSelectedRow();
            new Edit(this, 2, selected).setVisible(true);
        } else if (ae.getSource() == memBalance) {
            int selected = memberTable.getSelectedRow();
            new UserBalance(this, selected).setVisible(true);
        } else if (ae.getSource() == memWithdraw)  {
            int selected = memberTable.getSelectedRow();
            new Withdraw(this, selected).setVisible(true);
        } else if (ae.getSource() == memDel) {
            memberDeleted();
        } else if (ae.getSource() == memSearch) {
            permissionDenied();
            searchFor(2);
        } else if (ae.getSource() == noteView) {
            displayNotes();
        } else if (ae.getSource() == noteAdd) {
            new AddNote(this).setVisible(true);
        } else if (ae.getSource() == noteEdit) {
            int selected = notesTable.getSelectedRow();
            new Edit(this, 3, selected).setVisible(true);
        } else if (ae.getSource() == noteDel) {
            deleteNote();
        }
    }

    private void permissionDenied() {
        JOptionPane.showMessageDialog(this, "You do not have permission to perform the requested action.\nPlease speak to your system Administrator.", "Authentication Warning", JOptionPane.WARNING_MESSAGE);
    }

    //ID, Name, Address, Phone, password, balance, active, row
    protected void editMember(String ID, String Name, String Address, String Phone, String pass, double balance, int active, int row) {
        memberList.remove(row);
        User replace = new User();
        replace.setId(ID);
        replace.setName(Name);
        replace.setAddress(Address);
        replace.setPhone(Phone);
        replace.setActive(active);
        replace.setPassword(pass);
        replace.setBalance(String.valueOf(balance));
        addMemberToList(replace);
        overwriteFile("member");
        displayMembers();
    }

    protected void editNote(String ID, String Name, String Title, String Message, int row) {
        notesList.remove(row);
        Notes replace = new Notes();
        replace.setId(ID);
        replace.setUser(Name);
        replace.setTitle(Title);
        replace.setMessage(Message);
        addNotesToList(replace);
        overwriteFile("note");
        displayNotes();
    }

    public void addMemberToList(User user) {
        memberList.add(user);
    }

    public void addNotesToList(Notes note) {
        notesList.add(note);
    }

    private void searchFor(int input) {
        //new SearchUI(this, input).setVisible(true);
    }

    public void doSearch(int type, String input) {
        int j = 0;
        if (type == 1) {
            JOptionPane.showMessageDialog(this, "This search option has been disbled", "Developer Policy", JOptionPane.WARNING_MESSAGE);

        }
        if (type == 2 && Code.Details.USRTYPE.equals("Admin")) {
            String[] columns = new String[]{
                "ID", "Name", "Address", "Phone", "Active"
            };
            Object[][] filter = new Object[memberList.size()][6];
            Object[][] data = new Object[memberList.size()][6];
            for (int i = 0; i < memberList.size(); i++) {
                User user = memberList.get(i);
                data[i][0] = user.getId();
                data[i][1] = user.getName();
                data[i][2] = user.getAddress();
                data[i][4] = "07" + user.getPhone();
                data[i][5] = user.getBalance();
                data[i][6] = user.getActive();

                if (data[i][0].equals(input) | data[i][1].equals(input) | data[i][2].equals(input) | data[i][3].equals(input) | data[i][4].equals(input)) {

                    filter[j][0] = data[i][0];
                    filter[j][1] = data[i][1];
                    filter[j][2] = data[i][2];
                    filter[j][3] = data[i][3];
                    filter[j][4] = data[i][4];
                    filter[j][5] = data[i][5];
                    j++;
                }
                Object[][] result = new Object[j][6];
                for (int k = 0; k < j; k++) {
                    result[k][0] = filter[k][0];
                    result[k][1] = filter[k][1];
                    result[k][2] = filter[k][2];
                    result[k][3] = filter[k][3];
                    result[k][4] = filter[k][4];
                    result[k][5] = filter[k][5];
                }
                memberTable = new JTable(result, columns);
            }
            this.getContentPane().removeAll();
            this.getContentPane().add(new JScrollPane(memberTable));
            this.revalidate();
        } else if (type == 3 && Code.Details.USRTYPE.equals("Admin")) {
            String[] columns = new String[]{
                "Note ID", "User", "Note Title", "Note Message"
            };
            Object[][] filter = new Object[memberList.size()][6];
            Object[][] data = new Object[memberList.size()][6];
            for (int i = 0; i < memberList.size(); i++) {
                User user = memberList.get(i);
                data[i][0] = user.getId();
                data[i][1] = user.getName();
                data[i][2] = user.getAddress();
                data[i][4] = "07" + user.getPhone();
                data[i][5] = user.getBalance();

                if (data[i][0].equals(input) | data[i][1].equals(input) | data[i][2].equals(input) | data[i][3].equals(input) | data[i][4].equals(input)) {

                    filter[j][0] = data[i][0];
                    filter[j][1] = data[i][1];
                    filter[j][2] = data[i][2];
                    filter[j][3] = data[i][3];
                    filter[j][4] = data[i][4];
                    filter[j][5] = data[i][5];
                    j++;
                }
                Object[][] result = new Object[j][6];
                for (int k = 0; k < j; k++) {
                    result[k][0] = filter[k][0];
                    result[k][1] = filter[k][1];
                    result[k][2] = filter[k][2];
                    result[k][3] = filter[k][3];
                    result[k][4] = filter[k][4];
                    result[k][5] = filter[k][5];
                }
                memberTable = new JTable(result, columns);
            }
            this.getContentPane().removeAll();
            this.getContentPane().add(new JScrollPane(memberTable));
            this.revalidate();
        } else {
            permissionDenied();
        }
    }

    private void memberDeleted() {
        try {
            int selected = memberTable.getSelectedRow();
            User del = memberList.get(selected);
            sec.saveLog(Details.LoggedOn + " has deleted a member of the security team. The deleted details are: ID - " + String.valueOf(del.getId() + " Name -  " + del.getName() + "."));
            memberList.remove(selected);
            overwriteFile("member");
            displayMembers();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "You can't delete a member which isn't selected.", "Nothing Selected", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void deleteNote() {
        try {
            int selected = notesTable.getSelectedRow();
            notesList.remove(selected);
            overwriteFile("note");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "You can't delete a note which isn't selected.", "Nothing Selected", JOptionPane.PLAIN_MESSAGE);
        }
        displayNotes();
    }

    public void overwriteFile(String type) {
// This overwrite methos can be called for two members, one for books and one for notes.
// This option has been disabled as books aren't a part of the Security application.
        switch (type) {
            case "member": {
                File file = new File("C:\\RTC\\UserInfo\\members.dat");
                try {
                    try (FileWriter fw3 = new FileWriter(file, false)) {
                        BufferedWriter bw3 = new BufferedWriter(fw3);
                        //Make sure the file is blank.
                        bw3.write("");
                        bw3.close();
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "The system couldn't overwrite the file.\n" + e, "Overwrite Error", JOptionPane.WARNING_MESSAGE);
                }
                Object[][] data = new Object[memberList.size()][7];
                for (int i = 0; i < memberList.size(); i++) {
                    User user = memberList.get(i);
                    data[i][0] = user.getId();
                    data[i][1] = user.getName();
                    data[i][2] = user.getAddress();
                    data[i][3] = user.getPhone();
                    data[i][4] = user.getPassword();
                    data[i][5] = user.getBalance();
                    data[i][6] = user.getActive();
                    //Try to write the above information to the file.

                    StringBuilder build = new StringBuilder();
                    build.append(data[i][0]).append(en).append(data[i][1]).append(en).append(data[i][2]).append(en).append(data[i][3]).append(en).append(data[i][4]).append(en).append(data[i][5]).append(en).append(data[i][6]);

                    try {
                        sec.encDetails(String.valueOf(build), "members");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                break;
            }
            case "note": {
                Object[][] data = new Object[notesList.size()][4];
                // Create a new file writer here
                FileWriter fw3;
                //Make sure java knows where the file is stored
                File file2 = new File("C:\\RTC\\UserInfo\\notes.dat");
                //Delete the file and make a new one
                try {
                    fw3 = new FileWriter(file2, false);
                    //Make sure the file is blank.
                    try (BufferedWriter bw3 = new BufferedWriter(fw3)) {
                        //Make sure the file is blank.
                        bw3.write("");
                    }
                    fw3.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "The system couldn't overwrite the file.\n" + e, "Overwrite Error", JOptionPane.WARNING_MESSAGE);
                }
                for (int i = 0; i < notesList.size(); i++) {
                    Notes load = notesList.get(i);
                    data[i][0] = load.getId();
                    data[i][1] = load.getUser();
                    data[i][2] = load.getTitle();
                    data[i][3] = load.getMessage();

                    //Try to write the above information to the file.
                    StringBuilder build = new StringBuilder();
                    build.append(data[i][0]).append(en).append(data[i][1]).append(en).append(data[i][2]).append(en).append(data[i][3]).append(en);
                    try {
                        sec.encDetails(String.valueOf(build), "notes");
                    } catch (Exception ex) {
                        Logger.getLogger(UserAdminUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            }
            default:
                JOptionPane.showMessageDialog(this, "The overwrite method was called with an invalid input!", "Alert", JOptionPane.ERROR_MESSAGE);
                break;

        }

        /*
        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        !!PLEASE UNCOMMENT THIS SECTIOON TO GET THE PROGRAM TO SORT ROWS. !!
        !!THIS DOES NOT WORK CORRECTLY   vvv                              !!
        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         */

 /*
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(bookTable.getModel());
        bookTable.setRowSorter(sorter);
        
        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
        sortKeys.add(new RowSorter.SortKey(7, SortOrder.DESCENDING));
        sortKeys.add(new RowSorter.SortKey(5, SortOrder.DESCENDING));
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);
         */
        this.getContentPane().removeAll();
        this.getContentPane().add(new JScrollPane(bookTable));
        this.revalidate();
    }

    public void displayNotes() {
        String[] columns = new String[]{
            "Note ID", "User", "Note Title", "Note Message"
        };

        Object[][] data = new Object[notesList.size()][4];
        for (int i = 0; i < notesList.size(); i++) {
            Notes load = notesList.get(i);
            data[i][0] = load.getId();
            data[i][1] = load.getUser();
            data[i][2] = load.getTitle();
            data[i][3] = load.getMessage();
        }

        notesTable = new JTable(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.getContentPane().removeAll();
        this.getContentPane().add(new JScrollPane(notesTable));
        this.revalidate();
    }

    public void displayMembers() {
        //headers for the table
        String[] columns = new String[]{
            "ID", "Name", "Address", "Phone", "Balance", "Active"
        };

        Object[][] data = new Object[memberList.size()][6];
        for (int i = 0; i < memberList.size(); i++) {
            User member = memberList.get(i);
            data[i][0] = member.getId();
            data[i][1] = member.getName();
            data[i][2] = member.getAddress();
            data[i][3] = "07" + member.getPhone();
            data[i][4] = "£" + member.getBalance();
            int active = member.getActive();
            if (active == 1) {
                data[i][5] = true;
            } else {
                data[i][5] = false;
            }
        }
        memberTable = new JTable(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.getContentPane().removeAll();
        this.getContentPane().add(new JScrollPane(memberTable));
        this.revalidate();
    }

}
