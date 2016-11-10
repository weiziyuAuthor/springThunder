package yu.mediator;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class ColleagueTextField extends TextField implements TextListener,
		Colleague {

	private Mediator mediator;
	public ColleagueTextField(String text,int columns){
		super(text,columns);
	}
	
	
	public void textValueChanged(TextEvent e) {
		//若字符串有变化，则通知Mediator
		mediator.colleagueChanged(this);
	}

	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);
		setBackground(enabled?Color.white:Color.lightGray);
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

}
