package ph.gov.deped.common.util.builders;

import ph.gov.deped.data.dto.ColumnElement;

import com.bits.sql.JoinType;

public class JoinProperty {

	private JoinType joinType;
	private JoinInfo<ColumnElement, ColumnElement> joinInfo;
	
	
	protected JoinProperty() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected JoinProperty(JoinType joinType,
			JoinInfo<ColumnElement, ColumnElement> joinInfo) {
		super();
		this.joinType = joinType;
		this.joinInfo = joinInfo;
	}
	public JoinType getJoinType() {
		return joinType;
	}
	public void setJoinType(JoinType joinType) {
		this.joinType = joinType;
	}
	public JoinInfo<ColumnElement, ColumnElement> getJoinInfo() {
		return joinInfo;
	}
	public void setJoinInfo(JoinInfo<ColumnElement, ColumnElement> joinInfo) {
		this.joinInfo = joinInfo;
	}
	
	
}
