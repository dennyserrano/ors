package ph.gov.deped.data.dto;

public class JoinOperator 
{
	private JoinInfo<ColumnElement,ColumnElement> joinInfo;
	private OperatorType operator;
	public JoinOperator(JoinInfo<ColumnElement, ColumnElement> joinInfo,
			OperatorType operator) {
		super();
		this.joinInfo = joinInfo;
		this.operator = operator;
	}
	public JoinOperator() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JoinInfo<ColumnElement, ColumnElement> getJoinInfo() {
		return joinInfo;
	}
	public void setJoinInfo(JoinInfo<ColumnElement, ColumnElement> joinInfo) {
		this.joinInfo = joinInfo;
	}
	public OperatorType getOperator() {
		return operator;
	}
	public void setOperator(OperatorType operator) {
		this.operator = operator;
	}
	
	
}
