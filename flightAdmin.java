import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class flightAdmin extends JFrame implements ActionListener, ItemListener, ListSelectionListener{
	
	//Initialization of Variables
	
	JButton passenger, ticket, flights, crew, viewTable, editTable, insert; 
	
	final static String passengerTexts = "Passengers Table";
	final static String crewTexts = "Crew Table";
	final static String flightTexts = "Flights Table";
	final static String ticketTexts = "Tickets Table";
	
	String tableCheck; //This string is used to determine which table is currently active and in use. 
	
	JPanel card, titles;
	
	//Miscelaneous Textfields
	JTextField passID, firstName, lastName, dateOfBirth, premStat; 
	
	JTextField flightNum, crewID, flightTime, departTime, departLoc, arrivalTime, arriveLoc;
	
	JTextField ticketID, passIDField, gateNum;
	
	JTextField crewId, pilotName, faName, emHours;
	
	JTable passTable, flyTable, creTable, tickTable;
	
	JButton insertRecords, updateRecords, deleteRecords;
	
	String passCol[] = {"passID", "firstName", "lastName", "pDOB", "premStatus"};
	
	String flyCol[] = {"flightNum", "crewID", "flightTime", "departTime", "departLoc", "arrivalTime", "arriveLoc"};
	
	String tickCol[] = {"ticketID", "passID", "gateNum"};
	
	String crewCol[] = {"crewId", "pilotName", "faName", "emHours"};
	
	String inputOne, inputTwo, inputThree, inputFour, inputFive, inputSix, inputSeven;
	
	String sample[][] = {{"1", "2", "3", "4", "5", "6", "7"}, {"1", "4", "3", "4", "5", "6", "7"}};
	
	
	
	
	
	
	flightAdmin(){
		
		ImageIcon image = new ImageIcon("planelogo.png"); 
		 
		
	
		
		//Labels. 
		
		
		
		
		//Title Bar
		
		JLabel label = new JLabel();
		label.setText("PROJECT AIRLINES ADMINISTRATION"); 
		label.setIcon(image);
		label.setFont(new Font("Constantia", Font.BOLD, 36));
		label.setForeground(Color.white);
				
		JPanel namePlate = new JPanel(); 
		namePlate.setBackground(new Color(174,160,138));
		namePlate.setPreferredSize(new Dimension(100,50)); 
		
		JPanel menuBar = new JPanel();
		
		insertRecords = new JButton();
		insertRecords.setText("Insert Records");
		insertRecords.setPreferredSize(new Dimension(250,40));
		insertRecords.addActionListener(this);
		
		updateRecords = new JButton();
		updateRecords.setText("Update Records");
		updateRecords.setPreferredSize(new Dimension(250,40));
		updateRecords.addActionListener(this);
		
		deleteRecords = new JButton();
		deleteRecords.setText("Delete Records");
		deleteRecords.setPreferredSize(new Dimension(250,40));
		deleteRecords.addActionListener(this);
		
		titles = new JPanel();
		
		titles.setLayout(new BorderLayout(0, 0));
		titles.add(namePlate, BorderLayout.NORTH);
		titles.add(menuBar, BorderLayout.SOUTH);
		
		
		//Passenger Table Panels
		
		card = new JPanel(new CardLayout());
		
		JPanel passengerPanel = new JPanel(); 
		passengerPanel.setBackground(Color.gray);
		passengerPanel.setPreferredSize(new Dimension(300,300));
		
		JPanel passengerText = new JPanel();
		passengerText.setPreferredSize(new Dimension(300,300));
		
		JPanel passengerTable = new JPanel();
		passengerTable.setPreferredSize(new Dimension(300,300));
		
		
		
	// Passenger TextFields
		
		firstName = new JTextField();
		lastName = new JTextField();
		dateOfBirth = new JTextField();
		premStat = new JTextField();
		passID = new JTextField();
		
		
		passID.setPreferredSize(new Dimension(250,40));
		firstName.setPreferredSize(new Dimension(250,40));
		lastName.setPreferredSize(new Dimension(250,40));
		dateOfBirth.setPreferredSize(new Dimension(250,40));
		premStat.setPreferredSize(new Dimension(250,40));
		
		
		passengerText.add(firstName);
		passengerText.add(lastName);
		passengerText.add(dateOfBirth);
		passengerText.add(premStat);
		passengerText.add(passID);
		
		
		passTable = new JTable(sample, passCol);
		
		
		
		JScrollPane ptable = new JScrollPane(passTable);
		passengerTable.add(ptable);
		ListSelectionModel pmodel = passTable.getSelectionModel();
		pmodel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int selectedRow;
				
				selectedRow = passTable.getSelectedRow();
				
				firstName.setText(passTable.getValueAt(selectedRow, 0).toString()); 
				lastName.setText(passTable.getValueAt(selectedRow, 1).toString());
				dateOfBirth.setText(passTable.getValueAt(selectedRow, 2).toString());
				premStat.setText(passTable.getValueAt(selectedRow, 3).toString());
				passID.setText(passTable.getValueAt(selectedRow, 4).toString());
				
			}
			
		});
	
		
		passengerPanel.setLayout(new BorderLayout(0, 0));
		
		passengerPanel.add(passengerText, BorderLayout.WEST);
		passengerPanel.add(passengerTable, BorderLayout.CENTER);
		
		
		//Flights
		
		JPanel flightsPanel = new JPanel(); 
		flightsPanel.setPreferredSize(new Dimension(300,300));
		
		
		JPanel flightText = new JPanel();
		flightText.setPreferredSize(new Dimension(300,300));
		
		JPanel flightTable = new JPanel();
		flightTable.setPreferredSize(new Dimension(300,300));
		
		
		
		
		
		
		//Flights Textfields 
		
		flightNum = new JTextField();
		crewID = new JTextField();
		flightTime = new JTextField();
		departTime = new JTextField();
		departLoc = new JTextField();
		arrivalTime = new JTextField();
		arriveLoc = new JTextField();
		
		flightNum.setPreferredSize(new Dimension(250,40));
		crewID.setPreferredSize(new Dimension(250,40));
		flightTime.setPreferredSize(new Dimension(250,40));
		departTime.setPreferredSize(new Dimension(250,40));
		departLoc.setPreferredSize(new Dimension(250,40));
		arrivalTime.setPreferredSize(new Dimension(250,40));
		arriveLoc.setPreferredSize(new Dimension(250,40));
		
		flightText.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		
		flightText.add(flightNum);
		flightText.add(crewID);
		flightText.add(flightTime);
		flightText.add(departTime);
		flightText.add(departLoc);
		flightText.add(arrivalTime);
		flightText.add(arriveLoc);
		
		flyTable = new JTable(sample, flyCol);
		
		
		
		JScrollPane ftable = new JScrollPane(flyTable);
		flightTable.add(ftable);
		ListSelectionModel fmodel = flyTable.getSelectionModel();
		fmodel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int selectedRow;
				
				selectedRow = flyTable.getSelectedRow();
				

				flightNum.setText(flyTable.getValueAt(selectedRow, 0).toString()); 
				crewID.setText(flyTable.getValueAt(selectedRow, 1).toString());
				flightTime.setText(flyTable.getValueAt(selectedRow, 2).toString());
				departTime.setText(flyTable.getValueAt(selectedRow, 3).toString());
				departLoc.setText(flyTable.getValueAt(selectedRow, 4).toString());
				arrivalTime.setText(flyTable.getValueAt(selectedRow, 5).toString());
				arriveLoc.setText(flyTable.getValueAt(selectedRow, 6).toString());
				
			}
			
		});
		
		flightsPanel.setLayout(new BorderLayout(0, 0));
		
		flightsPanel.add(flightText, BorderLayout.WEST);
		flightsPanel.add(flightTable, BorderLayout.CENTER);
		
		
		//Tickets
		
		JPanel ticketPanel = new JPanel(); 
		ticketPanel.setPreferredSize(new Dimension(300,300));
		ticketPanel.setBackground(Color.red);
		
		JPanel ticketText = new JPanel();
		ticketText.setPreferredSize(new Dimension(300,300));
		
		JPanel ticketTable = new JPanel();
		passengerTable.setPreferredSize(new Dimension(300,300));
		
		ticketPanel.setLayout(new BorderLayout(0, 0));
		
	
		
		ticketID = new JTextField();
		passIDField = new JTextField();
		gateNum = new JTextField();
		
		
		ticketID.setPreferredSize(new Dimension(250,40));
		passIDField.setPreferredSize(new Dimension(250,40));
		gateNum.setPreferredSize(new Dimension(250,40));
		
		
		ticketText.add(ticketID);
		ticketText.add(passIDField);
		ticketText.add(gateNum);
		
		tickTable = new JTable(sample, tickCol);
		
		
		
		JScrollPane ttable = new JScrollPane(tickTable);
		ticketTable.add(ttable);
		ListSelectionModel tmodel = tickTable.getSelectionModel();
		tmodel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int selectedRow;
				
				selectedRow = tickTable.getSelectedRow();
				

				ticketID.setText(tickTable.getValueAt(selectedRow, 0).toString()); 
				passIDField.setText(tickTable.getValueAt(selectedRow, 1).toString());
				gateNum.setText(tickTable.getValueAt(selectedRow, 2).toString());

				
			}
			
		});
		
		ticketPanel.add(ticketText, BorderLayout.WEST);
		ticketPanel.add(ticketTable, BorderLayout.CENTER);
		
		
		//Crew
		
		JPanel crewPanel = new JPanel(); 
		crewPanel.setPreferredSize(new Dimension(300,300));
		crewPanel.setBackground(Color.blue);
		
		JPanel crewText = new JPanel();
		crewText.setPreferredSize(new Dimension(300,300));
		
		JPanel crewTable = new JPanel();
		crewTable.setPreferredSize(new Dimension(300,300));
		
		crewPanel.setLayout(new BorderLayout(0, 10));
		
	
		
		crewId = new JTextField();
		pilotName = new JTextField();
		faName = new JTextField();
		emHours = new JTextField();
	
		
		
		crewId.setPreferredSize(new Dimension(250,40));
		pilotName.setPreferredSize(new Dimension(250,40));
		faName.setPreferredSize(new Dimension(250,40));
		emHours.setPreferredSize(new Dimension(250,40));
		
		
		
		crewText.add(crewId);
		crewText.add(pilotName);
		crewText.add(faName);
		crewText.add(emHours);
		
		creTable = new JTable(sample, crewCol);
		
		
		
		JScrollPane ctable = new JScrollPane(creTable);
		crewTable.add(ctable);
		ListSelectionModel cmodel = creTable.getSelectionModel();
		cmodel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int selectedRow;
				
				selectedRow = creTable.getSelectedRow();
				

				crewId.setText(creTable.getValueAt(selectedRow, 0).toString()); 
				pilotName.setText(creTable.getValueAt(selectedRow, 1).toString());
				faName.setText(creTable.getValueAt(selectedRow, 2).toString());
				emHours.setText(creTable.getValueAt(selectedRow, 3).toString());

				
			}
			
		});
	
		crewPanel.add(crewText, BorderLayout.WEST);
		crewPanel.add(crewTable, BorderLayout.CENTER);
	
		
		
		
		String comboBoxItems[] = {passengerTexts, flightTexts, crewTexts, ticketTexts};
		
		JComboBox selections = new JComboBox(comboBoxItems);
		selections.setEditable(false);
		selections.addItemListener(this);
		
		
		card.add(passengerPanel, passengerTexts);
		card.add(crewPanel, crewTexts);
		card.add(flightsPanel, flightTexts);
		card.add(ticketPanel, ticketTexts);
		
	
		//Frame Settings
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1920,1080);
		this.setLayout(new BorderLayout(10, 10));
		this.setVisible(true);
		

		this.add(titles, BorderLayout.NORTH);
		this.add(card);
		
		
		menuBar.add(selections);
		menuBar.add(insertRecords);
		menuBar.add(updateRecords);
		menuBar.add(deleteRecords);
		namePlate.add(label);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==insertRecords) {
			switch(tableCheck) { //Switch statement to make sure button pulls from right set of tables
			case "Passengers Table":
				//get text from passenger fields
				inputOne = passID.getText();
				inputTwo = firstName.getText();
				inputThree = lastName.getText();
				inputFour = dateOfBirth.getText();
				inputFive = premStat.getText();
				//Insert method to insert to record.
			case "Flights Table":
				//get text from Flights
				inputOne = flightNum.getText();
				inputTwo = crewID.getText();
				inputThree = flightTime.getText();
				inputFour = departTime.getText();
				inputFive = departLoc.getText();
				inputSix = arrivalTime.getText();
				inputSeven = arriveLoc.getText();
			case "Tickets Table":
				inputOne = ticketID.getText();
				inputTwo = passIDField.getText();
				inputThree = gateNum.getText();
			case "Crew Table":
				inputOne = crewID.getText();
				inputTwo = pilotName.getText();
				inputThree = faName.getText();
				inputFour = emHours.getText();
			default:
				System.out.println("Something went wrong");
			}
			
		}
		else if(e.getSource()==updateRecords) {
			switch(tableCheck) { //Switch statement to make sure button pulls from right set of tables
			case "Passengers Table":
				//get text from passenger fields
				inputOne = passID.getText();
				inputTwo = firstName.getText();
				inputThree = lastName.getText();
				inputFour = dateOfBirth.getText();
				inputFive = premStat.getText();
				//Insert method to insert to record.
			case "Flights Table":
				//get text from Flights
				inputOne = flightNum.getText();
				inputTwo = crewID.getText();
				inputThree = flightTime.getText();
				inputFour = departTime.getText();
				inputFive = departLoc.getText();
				inputSix = arrivalTime.getText();
				inputSeven = arriveLoc.getText();
			case "Tickets Table":
				inputOne = ticketID.getText();
				inputTwo = passIDField.getText();
				inputThree = gateNum.getText();
			case "Crew Table":
				inputOne = crewID.getText();
				inputTwo = pilotName.getText();
				inputThree = faName.getText();
				inputFour = emHours.getText();
			default:
				System.out.println("Something went wrong");
			}
			
		}
		else if(e.getSource()==deleteRecords) {
			switch(tableCheck) { //Switch statement to make sure button pulls from right set of tables
			case "Passengers Table":
				//get text from passenger fields
				inputOne = passID.getText();
				inputTwo = firstName.getText();
				inputThree = lastName.getText();
				inputFour = dateOfBirth.getText();
				inputFive = premStat.getText();
				//Insert method to delete record.
			case "Flights Table":
				//get text from Flights
				inputOne = flightNum.getText();
				inputTwo = crewID.getText();
				inputThree = flightTime.getText();
				inputFour = departTime.getText();
				inputFive = departLoc.getText();
				inputSix = arrivalTime.getText();
				inputSeven = arriveLoc.getText();
			case "Tickets Table":
				inputOne = ticketID.getText();
				inputTwo = passIDField.getText();
				inputThree = gateNum.getText();
			case "Crew Table":
				inputOne = crewID.getText();
				inputTwo = pilotName.getText();
				inputThree = faName.getText();
				inputFour = emHours.getText();
			default:
				System.out.println("Something went wrong");
			}
		}
		else {
			//probably place an error message here. 
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent evt) {
		// TODO Auto-generated method stub
		CardLayout cl = (CardLayout)(card.getLayout());
	    cl.show(card, (String)evt.getItem());
	    tableCheck = (String)evt.getItem();
	    System.out.println(tableCheck);
	}

	

	
	//Row selection thing
	

}
/* Total of 4 tables therefore 4 options in the selection
 * 2 sub panels per card form and buttons then table selector
 * clicking on the table causes the corresponding record to be displayed in the textboxs
 * from here can delete or edit
 * tables have a method that ensures that the
 */
