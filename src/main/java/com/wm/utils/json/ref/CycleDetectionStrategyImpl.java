package com.wm.utils.json.ref;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.CycleDetectionStrategy;

public class CycleDetectionStrategyImpl extends CycleDetectionStrategy{
	@Override
	public JSONArray handleRepeatedReferenceAsArray(Object arg0) {
		// TODO Auto-generated method stub
		return JSONArray.fromObject("[]");
	}

	@Override
	public JSONObject handleRepeatedReferenceAsObject(Object arg0) {
		// TODO Auto-generated method stub
		return JSONObject.fromObject("{}");
	}
}
