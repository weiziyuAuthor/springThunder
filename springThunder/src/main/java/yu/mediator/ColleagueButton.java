package yu.mediator;

import java.awt.Button;

public class ColleagueButton extends Button implements Colleague {
	private Mediator mediator;
	
	public ColleagueButton(String caption){
		super(caption);
	}
	
	public void setColleagueEnabled(boolean enabled) {
		//mediator 指示有效无效
		setEnabled(enabled);
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

}
