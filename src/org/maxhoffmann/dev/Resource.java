package org.maxhoffmann.dev;

public class Resource
{
	private int resourceId;
	private String segmentId;
	
	public int getRESOURCEID() {
		return this.resourceId;
	}
	
	public String getWORKPLACENO() {
		return this.segmentId;
	}
	
	public void setRESOURCEID(int resourceId) {
		this.resourceId = resourceId;
	}
	
	public void setWORKPLACENO(String segmentId) {
		this.segmentId = segmentId;
	}
	
}