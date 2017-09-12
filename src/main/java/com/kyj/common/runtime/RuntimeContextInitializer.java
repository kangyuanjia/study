package com.kyj.common.runtime;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;

import com.kyj.common.cache.CacheManager;
import com.kyj.common.conf.ConfigureManager;
import com.kyj.common.session.CustomHttpSession;
import com.kyj.common.session.SessionManager;
import com.kyj.common.session.User;

public class RuntimeContextInitializer implements InitializingBean {
	private Logger log;

	public RuntimeContextInitializer() {
		this.log = Logger.getLogger(RuntimeContextInitializer.class);
	}

	public void afterPropertiesSet() throws Exception {
		loadConfig();
	}

	private void loadConfig() {
		try {
			Properties props = ConfigureManager.getRootConf();
			loadAdditionnalConfigures(props);
			String sessionId = SessionManager.initSystemSession();
			CustomHttpSession cipSession = SessionManager.getSystemSession(sessionId);
			User systemUser = new User();
			systemUser.setUserId("system");
			systemUser.setUserName("system user");

			cipSession.setAttribute("login_user", systemUser, false);
			Runtime.runtimeInfo.put("system_session_id", sessionId);
		} catch (Exception e) {
			e.printStackTrace();
			this.log.error("配置文件config.properties加载失败！");
		} finally {
		}
	}

	private void loadAdditionnalConfigures(Properties props) {
		
		String cacheRemote = props.getProperty("cache.xremote").trim();
	    if ((cacheRemote != null) && (!(cacheRemote.equals("X")))) {
	      RuntimeConfigure.cip_is_remote_cache = false;
	    }
	    else {
	      RuntimeConfigure.cip_is_remote_cache = true;
	    }
	    if (RuntimeConfigure.cip_is_remote_cache) {
	      CacheManager.createCacheManager(1);
	    }
	    else {
	      CacheManager.createCacheManager(0);
	    }
		
		RuntimeConfigure.cip_actual_file_path = props.getProperty("upload.file.path").trim();
		RuntimeConfigure.cip_temp_file_path = props.getProperty("temp.file.path").trim();
		RuntimeConfigure.resources_without_login = props.getProperty("without.login").trim().split(";");
	}
}
