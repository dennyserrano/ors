package ph.gov.deped.common.util.builders;

import com.bits.sql.JoinType;

public class JoinInfo<L,R>
{
	private L left;
	private R right;
	private JoinType type;
	
	
	protected JoinInfo(L left, R right, String type) {
		this(left,right);
		this.type=JoinType.valueOf(type);
	}
	
	protected JoinInfo(L left,R right, JoinType type){
		this(left,right);
		this.type=type;
	}
	
	private JoinInfo(L left,R right)
	{
		this.left = left;
		this.right = right;
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

	public JoinType getType() {
		return type;
	}

	public void setType(JoinType type) {
		this.type = type;
	}
	
	
}
