package com.kyj.common.filter;

import java.util.List;

public class UserInfoData {
	public String sys_id;
	public String user_id;
	public String user_name;
	public String user_pwd;
	public int user_pwd_init;
	public int pwd_reset_days;
	public int pwd_reset_flag;
	public String org_id;
	public String position_id;
	public String persion_id;
	public int user_status = 0;
	public int user_type = 0;
	public String pwd_set_time;
	public String lang;
	public String start_date;
	public String end_date;
	public List<String> user_roles;
	public String org_name;
	public String org_type;
}
