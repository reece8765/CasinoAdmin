/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2019 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 */
package Server;

import Code.Security;

/**
 *
 * @author reece
 */
public class Clients {

    private boolean active;
    public final int max_clients = 16;
    private final Security sec = new Security();

    private final String[] clients = new String[max_clients];
    private final String[] IPs = new String[clients.length];

    public void initialise() {
        for (int i = 0; i < clients.length; i++) {
            clients[i] = "";
            IPs[i] = "";
        }
    }

    //CHANGE THIS BACK TO PROTECTED LATER
    public void load(boolean type) throws Exception {
        String clients[];
        if (!type) {
            //Decode the clients.dat file
            clients = sec.decSLineFile("lockdown", "clients.dat").split("::");

        } else {
            //Decode the clients.dat file
            clients = sec.decAll("C:\\RTC\\debug\\", "clients.dat", true).split("::");
        }
        String data[] = new String[max_clients * 2];
        String temp[];
        for (int i = 0; i< clients.length; i++) {
            System.out.println(clients[i]);
        }
        
        for (int i = 0; i < clients.length * 2;) {
            temp = String.valueOf(clients[i]).split("@@");
            if (!temp[0].equals("null")) {
                data[i] = temp[0];
                data[i + 1] = temp[1];
                i = i + 2;
            } else {
                break;
            }
        }

        int clientNum = 0;
        for (int i = 0; i < data.length; i += 2) {
            clients = null;

            this.clients[clientNum] = String.valueOf(data[i + 1]);
            this.IPs[clientNum] = String.valueOf(data[i]);
            clientNum++;
        }

        for (int i = 0; i < max_clients; i++) {
            System.out.println("Client #" + (i + 1) + " name + IP: " + this.clients[i] + " - " + IPs[i]);
        }
    }

    public void addClient(String client, String IP) throws Exception {
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].equals("")) {
                clients[i] = client;
                IPs[i] = IP;
                break;
            }
        }
        save();
    }

    private void save() {
        try {
            load(false);
        } catch (Exception reason) {
            System.out.println("Nothing to load. Reason: " + reason + " - it's probably fine to ignore this.");
        }
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < clients.length; i++) {
            if (!clients[i].equals("")) {
                temp.append(clients[i]).append("@@").append(IPs[i]).append("::");
            }
        }
        try {
            sec.encryptFile("C:\\RTC\\lockdown\\", "clients.dat", String.valueOf(temp));
        } catch (Exception ignore) {
            System.out.println(ignore);
        }
        temp = null;
    }

    public String[] getClients() {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < clients.length; i++) {
            if (!clients[i].equals("")) {
                temp.append("Computer #").append(i + 1).append(" - ").append(clients[i]).append(": ").append(IPs[i]).append("##");
            }
        }
        return String.valueOf(temp).split("@");
    }

    public String getClientIP(String Client) {
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].equals(Client)) {
                return IPs[i];
            }
        }
        return "";
    }

    public boolean isServerActive() {
        return active;
    }

    public void serverActive(boolean status) {
        active = status;
    }
}
