package yu.chainOfResponsebility;

public class LimitSupport extends Support {
	//若小于此号码则可以解决问题
	private int limit;
	
	public LimitSupport(String name,int limit){
		super(name);
		this.limit = limit;
	}
	
	@Override
	protected boolean resolve(Trouble trouble) {
		if(trouble.getNumber()<limit){
			return true;
		}else{
			return false;	
		}
		
	}

}
