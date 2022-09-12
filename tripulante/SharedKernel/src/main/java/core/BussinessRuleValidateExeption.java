package core;

import java.io.Serializable;

public class BussinessRuleValidateExeption
	extends Exception
	implements Serializable {

	public BussinessRule BrokenRule;
	public String Details;

	public BussinessRuleValidateExeption(String detail) {
		Details = detail;
	}

	public BussinessRuleValidateExeption(BussinessRule brokenRule) {
		BrokenRule = brokenRule;
		Details = brokenRule.Message();
	}

	public String getDetails() {
		return Details;
	}

	public BussinessRule getBrokenRule() {
		return BrokenRule;
	}

	@Override
	public String toString() {
		String name = BrokenRule == null
			? "BussinessRule"
			: BrokenRule.getClass().getName();
		return name + ':' + Details;
	}
}
