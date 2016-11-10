package yu.mediator;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener,Mediator{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ColleagueCheckBox checkGuest;
	private ColleagueCheckBox checkLogin;
	private ColleagueTextField textUser;
	private ColleagueTextField textPass;
	private ColleagueButton buttonOk;
	private ColleagueButton buttonCancel;
	
	public LoginFrame(String title){
		super(title);
		setBackground(Color.lightGray);
		
		setLayout(new GridLayout(4,2));
		//产生Colleague
		createColleagues();
		add(checkGuest);
		add(checkLogin);
		add(new Label("Username:"));
		add(textUser);
		add(new Label("Password:"));
		add(textPass);
		add(buttonOk);
		add(buttonCancel);
		//有效 无效的初始化设定
		colleagueChanged(checkGuest);
		
		pack();
		show();
		
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println(""+e);
		System.exit(0);
	}

	public void colleagueChanged(Colleague c) {
		if(c == checkGuest || c == checkLogin){
			if(checkGuest.getState()){
				//Guest模式 
				textUser.setColleagueEnabled(false);
				textPass.setColleagueEnabled(false);
				buttonOk.setColleagueEnabled(true);
			}else{
				textUser.setColleagueEnabled(true);
				userpassChanged();
			}
		}else if(c == textUser || c == textPass){
			userpassChanged();
		}else{
			System.out.println("colleagueChanged:unknown colleague = "+c);
		}
	}

	public void createColleagues() {
		CheckboxGroup g = new CheckboxGroup();
		checkGuest = new ColleagueCheckBox("Guest",g,true);
		checkLogin = new ColleagueCheckBox("Login",g,true);
		
		textUser = new ColleagueTextField("",10);
		textPass = new ColleagueTextField("",10);
		
		textPass.setEchoChar('*');
		buttonOk = new ColleagueButton("OK");
		buttonCancel = new ColleagueButton("Cancel");
		//Mediator的部分
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		buttonOk.setMediator(this);
		buttonCancel.setMediator(this);
		
		//listener部分
		checkGuest.addItemListener(checkGuest);
		checkLogin.addItemListener(checkLogin);
		textUser.addTextListener(textUser);
		textPass.addTextListener(textPass);
		buttonOk.addActionListener(this);
		buttonCancel.addActionListener(this);
		
	}
	

	private void userpassChanged(){
		if(textUser.getText().length()>0){
			textPass.setColleagueEnabled(true);
			if(textPass.getText().length()>0){
				buttonOk.setColleagueEnabled(true);
			}else{
				buttonOk.setColleagueEnabled(false);
			}
		}else{
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(false);
		}
	}
	

}
