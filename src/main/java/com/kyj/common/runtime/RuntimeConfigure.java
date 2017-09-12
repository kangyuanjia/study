package com.kyj.common.runtime;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RuntimeConfigure {
	public static String[] resources_without_login;
	public static String cip_system_id;
	public static String cip_system_instance_id;
	public static String cip_system_type;
	public static boolean cip_is_cluster = false;

	public static boolean cip_is_remote_conf = false;
	public static String cip_remote_conf_url;
	public static String cip_remote_conf_auth_code;
	public static final String cip_root_conf_file = "config.properties";
	public static String cip_conf_extend_file;
	public static String cip_conf_redis_file;
	public static String cip_conf_log4j_file;
	public static boolean cip_is_remote_log = false;
	public static String cip_log_url;
	public static boolean cip_is_remote_cache = true;

	public static boolean cip_cas_sso = false;

	public static boolean cip_user_xremote = false;
	public static boolean cip_auth_xremote = false;
	public static String cip_user_url;
	public static String cip_login_url;
	public static String cip_login_role_url;
	public static String cip_user_role_url;
	public static String cip_sync_role_to_auth_url;
	public static String cip_auth_url;
	public static String cip_menu_url;
	public static long cip_auth_Id;
	public static String cip_default_role;
	public static boolean cip_text_xremote;
	public static String cip_text_remote_url;
	public static String cip_text_local_file;
	public static String jndiName;
	public static String dbSchema;
	public static String loginURL;
	public static String menuURL;
	public static String loginPageURI = "login.html";
	public static String ErrorPageURI = "error.html";

	public static Properties additionalInfos = new Properties();

	public static String cip_default_lang = "ZH";
	public static String cip_temp_file_path;
	public static String cip_actual_file_path;
	public static List<String> defaultOrgTypes = new ArrayList();
	public static String dbSchema_ydserver = "ydserver.";
	public static String cip_conf_changesync_url;
}
