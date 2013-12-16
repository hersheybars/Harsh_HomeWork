/*
 * Start of program
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATM {

    public static void main(String[] args) {
        BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
        int menu = 0; //ung choices nia sa main menu
        int ctr = 0; // count of total no. of students
        String choice = ""; //answering yes or no
        int a = 0, b;
//int AccountBalance, NewBalance, WithdrawalBalance,WB;
        ATMBean[] asr = new ATMBean[10];
        do {
//menu = 4;
            System.out.println("*************************");
            System.out.println("");
            System.out.println("W E L C O M E");
            System.out.println("");
            System.out.println("");
            System.out.println("MENU");
            System.out.println("");
            System.out.println("[1] New Account");
            System.out.println("[2] Inquire Balance");
            System.out.println("[3] Deposit");
            System.out.println("[4] Withdrawal");
            System.out.println("[0] Quit Application");
            System.out.println("");
            System.out.println("*************************");
            System.out.println("");
            System.out.print("\nInput your Choice:");
            try {
                try {
                    menu = Integer.parseInt(dataIn.readLine());
                } catch (IOException e) {
                    System.out.println("IO Error!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Number Format Error!");
            }
            System.out.print("\n");
            switch (menu) {
                case 1: // NEW ACCOUNT CODING!
                    if (ctr <= 9) {
                        do {
                            asr[ctr] = new ATMBean();
                            try {
                                if (ctr != 0) {
                                    do {
                                        boolean c = false;
                                        b = 0;
                                        System.out.print("Pin Code:");
                                        asr[ctr].setpc(dataIn.readLine());
                                        for (a = 0; a <= ctr; a++) {
                                            c = asr[ctr].getpc().equalsIgnoreCase(asr[a].getpc());
                                            if (c) {
                                                b++;
                                            }
                                        }
                                        if (b != 1) {
                                            System.out.print("");
                                            System.out.println("Account Already Exist!");
                                            System.out.println("Try Inputting Another!");
                                        }
                                    } while (b != 1);
                                } else {
                                    System.out.print("");
                                    System.out.print("Input Desired Pin Code:");
                                    asr[ctr].setpc(dataIn.readLine());
                                }
                                System.out.print("Input Name: ");
                                asr[ctr].setName(dataIn.readLine());
                                System.out.print("Input Address: ");
                                asr[ctr].setAddress(dataIn.readLine());
                                System.out.print("Input Age: ");
                                asr[ctr].setAge(Integer.parseInt(dataIn.readLine()));
                                System.out.print("Input Balance: ");
                                asr[ctr].setBalance(Double.parseDouble(dataIn.readLine()));
                                System.out.println(" ");
                                System.out.println("ACCOUNT SUCCESSFULLY ADDED!");
                                System.out.println(" ");
//just displaying inputted records...
                                System.out.println("PinCode \t Name \t Address \t Age \t Balance");
                                System.out.print("");
                                System.out.print("HIDDEN \t");
                                System.out.print(asr[ctr].getName() + "\t");
                                System.out.print(asr[ctr].getAddress() + "\t");
                                System.out.print(asr[ctr].getAge() + "\t");
                                System.out.print(asr[ctr].getBalance() + "\t");
                                System.out.println(" ");
                                System.out.println(" ");
                                System.out.println("Total Number of Account/s " + (ctr + 1));
                            } catch (IOException e) {
                                System.out.print("Error!");
                            }
                            System.out.println("");
                            System.out.print("\nInput Another Account [Y/N]? :");
                            try {
                                try {
                                    choice = dataIn.readLine().toUpperCase();
                                } catch (IOException e) {
                                    System.out.println("IO Error!");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Number Format Error!");
                            }
                            System.out.print("\n");
                            ctr++;
                        } while (choice.equalsIgnoreCase("Y"));
                    } else {
                        System.out.println("Sorry, no space for new account!");
                        break;
                    }
                    break;
                case 2: // INQUIRE BALANCE
                    if (ctr != 0) {
                        do {
                            System.out.println("");
                            System.out.print("Pin Code:");
                            String search = "";
                            boolean found = false;
                            try {
                                search = dataIn.readLine();
                            } catch (IOException e) {
                                System.out.println("Error!");
                            }
                            for (a = 0; a < ctr; a++) {
                                found = search.equalsIgnoreCase(asr[a].getpc());
                                if (found) {
//just displaying inputted records...
                                    System.out.print("");
                                    System.out.print("Balance:");
                                    System.out.print("");
                                    System.out.print(asr[a].getBalance());
                                    System.out.print("");
                                    break;
                                }
                            }
                            if (!found) {
                                System.out.println("Pin Code Error!");
                                System.out.println("");
                                System.out.print("\nTry again [Y/N]? :");
                            }
                            try {
                                try {
                                    choice = dataIn.readLine().toUpperCase();
                                } catch (IOException e) {
                                    System.out.println("IO Error!");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Number Format Error!");
                            }
                        } while (choice.equalsIgnoreCase("Y"));
                    } else {
                        System.out.println("No Account/s Recorded yet!");
                    }
                    break;
                case 3://Deposit
                    if (ctr != 0) {
                        do {
                            System.out.println("");
                            System.out.print("Pin Code:");
                            String search = "";
                            boolean found = false;
                            try {
                                search = dataIn.readLine();
                            } catch (IOException e) {
                                System.out.println("Error!");
                            }
                            for (a = 0; a < ctr; a++) {
                                found = search.equalsIgnoreCase(asr[a].getpc());
                                if (found) {
                                    found = true;
                                    break;
                                }
                            }
                            if (found) {
                                b = a;//edit or delete purpose
                                try {
                                    System.out.println("");
                                    System.out.println("DEPOSIT!");
                                    System.out.println("");
                                    System.out.print("Input Amount:");
                                    asr[b].setBalance(asr[a].getBalance()+Double.parseDouble(dataIn.readLine()));
                                } catch (IOException e) {
                                    System.out.print("Error!");
                                }
                                System.out.println("Account Successfully Deposited!!");
                                System.out.println("");
                                System.out.println("New Balance:");
                                System.out.println("");
                                System.out.print(asr[b].getBalance());
                            }
                            if (!found) {
                                System.out.println("Pin Code Error!");
                                System.out.println("");
                                System.out.print("\nTry again [Y/N]? :");
                            }
                            try {
                                try {
                                    choice = dataIn.readLine().toUpperCase();
                                } catch (IOException e) {
                                    System.out.println("IO Error!");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Number Format Error!");
                            }
                        } while (choice.equalsIgnoreCase("Y"));
                    } else {
                        System.out.println("No Account/s Recorded yet!");
                    }
                    break;
                case 4://withdrawal
                    if (ctr != 0) {
                        do {
                            System.out.println("");
                            System.out.print("Pin Code:");
                            String search = "";
                            boolean found = false;
                            try {
                                search = dataIn.readLine();
                            } catch (IOException e) {
                                System.out.println("Error!");
                            }
                            for (a = 0; a < ctr; a++) {
                                found = search.equalsIgnoreCase(asr[a].getpc());
                                if (found) {
                                    found = true;
                                    break;
                                }
                            }
                            if (found) {
                                b = a;//edit or delete purpose
//                                a = ctr;//to stop looping
                                try {
                                    System.out.println("");
                                    System.out.println("WITHDRAWAL!");
                                    System.out.println("");
                                    System.out.print("Input Amount:");
                                    double sd=Double.parseDouble(dataIn.readLine());
                                    asr[a].setWB(sd);
                                    if ((asr[a].getWB()) <= (asr[a].getBalance()));
                                    {
                                        asr[a].setBalance(asr[a].getBalance()-asr[a].getWB());

                                    }
                                    System.out.print(asr[a].getWB());
                                } catch (IOException e) {
                                    System.out.print("Error!");
                                }
                                System.out.println("Account Successfully Withdrawn!!");
                                System.out.println("");
                                System.out.println("New Balance:");
                                System.out.println("");
                                System.out.print(asr[b].getBalance());
                            }
                            if (!found) {
                                System.out.println("Pin Code Error!");
                                System.out.println("");
                                System.out.print("\nTry again [Y/N]? :");
                            }
                            try {
                                try {
                                    choice = dataIn.readLine().toUpperCase();
                                } catch (IOException e) {
                                    System.out.println("IO Error!");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Number Format Error!");
                            }
                        } while (choice.equalsIgnoreCase("Y"));
                    } else {
                        System.out.println("No Account/s Recorded yet!");
                    }
                    break;
                case 0://end of program
                    break;
                default:
                    System.out.println("Invalid Input!");
            }
        } while (menu != 0);
        System.out.println("Thank You!");
        System.out.println("GOOD BYE... :)");
    }
}
