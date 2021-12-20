package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Core.Building;
import Core.Site;

public class BuildingForm extends JFrame implements ActionListener{

    JPanel building_window;
    JButton btnAdd, btnUpdate, btnDelete,btnClear;
    JLabel lblBuildingName, lblBuildingId, lblYear, lblCost, lblBuildingType, lblLocation, lblSiteName, lblUsername, image_label, logo_label, header_label;
    JTextField txtBuildingName, txtBuildingId,txtCost,txtLocation,txtSiteName,txtUsername,txtYear;
    JComboBox<String> cmbBuildingType;



    BuildingForm()
    {
        this.setTitle("New Building");
        setSize(700,520);
        setLocationRelativeTo(null);
        setResizable(false);

        btnAdd = new JButton("Add");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnClear = new JButton("Clear");

        btnAdd.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnClear.addActionListener(this);

        building_window = new JPanel();
        building_window.setLayout(null);
        building_window.setBackground(new Color(0,0,0));
        this.getContentPane().add(building_window);
        building_window.setBounds(0, 0, 400, 500);
        
        header_label = new JLabel("Building Form");
        header_label.setFont(new Font("Arial", Font.BOLD, 18));
        header_label.setForeground(Color.WHITE);
        header_label.setBounds(260,3,150,35);

        lblBuildingName = new JLabel("Building Name:");
        lblBuildingId = new JLabel("Building ID:");
        lblYear = new JLabel("Year:");
        lblCost = new JLabel("Cost:");
        lblBuildingType = new JLabel("Building Type:");
        lblLocation = new JLabel("Location:");
        lblSiteName = new JLabel("Site Name:");
        lblUsername = new JLabel("Username:");

        txtBuildingName = new JTextField();
        txtBuildingId = new JTextField();
        txtYear = new JTextField();
        txtCost = new JTextField();
        txtLocation = new JTextField();
        txtSiteName = new JTextField();
        txtUsername = new JTextField();

        
        String Options[] = {" ","House","Office"};
        cmbBuildingType = new JComboBox<String>(Options);

        image_label = new JLabel("");
        image_label.setIcon(new ImageIcon(this.getClass().getResource("assets/building.jpg")));
        image_label.setLayout(null);
        image_label.setBounds(0, 40, 700, 500);
        building_window.add(image_label);

        logo_label = new JLabel("");
        logo_label.setIcon(new ImageIcon(this.getClass().getResource("assets/logo.jpg")));
        logo_label.setBounds(3, 0, 50, 40);
        building_window.add(logo_label);

        lblBuildingId.setBounds(150, 40, 100, 25);
        txtBuildingId.setBounds(250, 40, 120, 25);

        lblBuildingName.setBounds(150, 80, 100, 25);
        txtBuildingName.setBounds(250, 80, 120, 25);

        lblYear.setBounds(150, 120, 100, 25);
        txtYear.setBounds(250, 120, 120, 25);

        lblCost.setBounds(150, 160, 100, 25);
        txtCost.setBounds(250, 160, 120, 25);

        lblBuildingType.setBounds(150, 200, 100, 25);
        cmbBuildingType.setBounds(250, 200, 120, 25);

        lblLocation.setBounds(150, 240, 100, 25);
        txtLocation.setBounds(250, 240, 120, 25);

        lblSiteName.setBounds(150, 280, 100, 25);
        txtSiteName.setBounds(250, 280, 120, 25);

        lblUsername.setBounds(150, 320, 100, 25);
        txtUsername.setBounds(250, 320, 120, 25);

        btnAdd.setBounds(120, 370, 80, 25);
        btnUpdate.setBounds(202, 370, 80, 25);
        btnDelete.setBounds(284, 370, 80, 25);
        btnClear.setBounds(366, 370, 80, 25);

        building_window.add(header_label);
        image_label.add(lblBuildingId);
        image_label.add(txtBuildingId);
        image_label.add(lblBuildingName);
        image_label.add(txtBuildingName);
        image_label.add(lblYear);
        image_label.add(txtYear);
        image_label.add(lblCost);
        image_label.add(txtCost);
        image_label.add(lblBuildingType);
        image_label.add(cmbBuildingType);
        image_label.add(lblLocation);
        image_label.add(txtLocation);
        image_label.add(lblSiteName);
        image_label.add(txtSiteName);
        image_label.add(lblUsername);
        image_label.add(txtUsername);

        image_label.add(btnAdd);
        image_label.add(btnUpdate);
        image_label.add(btnDelete);
        image_label.add(btnClear);


        add(building_window, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        public void actionPerformed(ActionEvent ae)
        {
            int BuildingId = Integer.parseInt(txtBuildingId.getText());
            String BuildingName = txtBuildingName.getText();
            String Year = txtYear.getText();
            long Cost = Integer.parseInt(txtCost.getText());
            String BuildingType = cmbBuildingType.getSelectedItem().toString();
            String Location = txtLocation.getText();
            String SiteName = txtSiteName.getText();
            String Username = txtUsername.getText();

            Building b = new Building(BuildingId,BuildingName,BuildingType,Year,SiteName,Cost,Username);
            

            if(ae.getSource()==btnAdd)
            {
                if(b.addDetails())
                {
                    Site s = new Site(); 
                    ArrayList<String> location = s.getLocations();
                    if (location.size() == 0)
                    {
                        JOptionPane.showMessageDialog(null, "No sites exist.");
                        dispose(); 
                    }
                    else
                    
                    JOptionPane.showMessageDialog(null,"Building Added Successfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Error Adding Building");
                }
            }

            else if(ae.getSource()==btnUpdate)
            {
                if(b.updateDetails())
                {
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    this.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Error in Updation");
                }
            }

            else if(ae.getSource()==btnDelete)
            {
                if(b.deleteDetails())
                {
                    JOptionPane.showMessageDialog(null,"Deleted Successfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Error in Deletion");
                }
            }

            else if(ae.getSource()==btnClear)
            {
                txtBuildingId.setText("");
                txtBuildingName.setText("");
                txtYear.setText("");
                txtCost.setText("");
                txtLocation.setText("");
                txtSiteName.setText("");
                txtUsername.setText("");
            }
        }
    public static void main(String[] args) {
        BuildingForm buildingForm = new BuildingForm();
        buildingForm.setVisible(true);
    }
}
