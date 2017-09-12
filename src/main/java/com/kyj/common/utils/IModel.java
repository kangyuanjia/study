package com.kyj.common.utils;

public interface IModel <T>{
	
	public boolean init(long authId, String dataId, 
			EditMode EditMode, AccessMode accessMode) throws Exception;
	
	public T read();
	
	public void write(T data);
	
	public void save() throws Exception;
	
	/** 集群环境下对象锁生效的前提是 各服务器时间一致*/
	public void lock(String userId, long timeMills) throws Exception;
	
	public boolean isLocked();
	
	public void setEditMode(EditMode editMode);
	
	public EditMode getEditMode();
}
