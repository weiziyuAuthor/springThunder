package yu.mediator;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColleagueCheckBox extends Checkbox implements ItemListener,
		Colleague {

	private Mediator mediator;
	public ColleagueCheckBox(String caption,CheckboxGroup group,boolean state){
		super(caption,group,state);
	}
	
	public void itemStateChanged(ItemEvent e) {
		//若状态有变，通知mediator
		mediator.colleagueChanged(this);
	}

	public void setColleagueEnabled(boolean enabled) {
		//Mediator指示有效  无效
		setEnabled(enabled);
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

}
