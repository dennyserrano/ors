package ph.gov.deped.data.dto;

public class JoinInfo<L,R>
{
	private L left;
	private R right;
	private String type;
	
	
	
	public JoinInfo(L left, R right, String type) {
		super();
		this.left = left;
		this.right = right;
		this.type = type;
	}
	public L getLeft() {
		return left;
	}
	public void setLeft(L left) {
		this.left = left;
	}
	public R getRight() {
		return right;
	}
	public void setRight(R right) {
		this.right = right;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
