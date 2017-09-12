package com.kyj.common.conf;

import com.kyj.common.runtime.RuntimeConfigure;
import java.util.List;
import java.util.Properties;

public class ConfigureManager {
	private static ConfigureService rootConfigure = null;
	private static ConfigureService configureService = null;

	public static void init() throws Exception {
		if (RuntimeConfigure.cip_is_remote_conf) {
		} else {
			configureService = new LocalConfigureService();
		}
	}

	public static Properties getRootConf() throws Exception {
		if (rootConfigure != null) {
			return rootConfigure.getPConfigures("config.properties");
		}
		rootConfigure = new LocalConfigureService();
		rootConfigure.init("config.properties");

		return rootConfigure.getPConfigures("config.properties");
	}

	public static Properties getConfigures(String confFile) {
		configureService = new LocalConfigureService();
		return configureService.getPConfigures(confFile);
	}

	public static Properties getConfigureTexts(String confFile) {
		List<ConfigureData> confs = configureService.getConfigures(confFile);
		Properties m = new Properties();
		for (ConfigureData conf : confs) {
			m.setProperty(conf.getConf_id(), conf.getConf_value_desc());
		}
		return m;
	}

	public static Properties getConfigures() {
		List<ConfigureData> confs = configureService.getConfigures();
		Properties m = new Properties();
		for (ConfigureData conf : confs) {
			m.setProperty(conf.getConf_id(), conf.getConf_value());
		}
		return m;
	}

	public static Properties getConfigureTexts() {
		List<ConfigureData> confs = configureService.getConfigures();
		Properties m = new Properties();
		for (ConfigureData conf : confs) {
			m.setProperty(conf.getConf_id(), conf.getConf_value_desc());
		}
		return m;
	}
}