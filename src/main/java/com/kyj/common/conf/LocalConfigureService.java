package com.kyj.common.conf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.kyj.common.exception.CustomRuntimeException;
import com.kyj.common.runtime.CustomErrorCode;

public class LocalConfigureService implements ConfigureService {
	private Map<String, Properties> confs;

	public LocalConfigureService() {
		this.confs = new HashMap();
	}

	public void init(String fileName) throws Exception {
		String confFile = fileName;
		InputStream stream = null;
		Properties props = null;
		props = new Properties();
		stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(confFile);
		props.load(stream);
		this.confs.put(fileName, props);
	}

	public ConfigureData getConfigure(String confFile, String confId) {
		if (this.confs.get(confFile) != null) {
			Properties p = (Properties) this.confs.get(confFile);
			ConfigureData conf = new ConfigureData();
			conf.setConf_id(confId);
			conf.setConf_value(p.getProperty(confId));
			return conf;
		}

		return null;
	}

	private List<ConfigureData> getProperties(Properties props) {
		Enumeration es = props.keys();
		Object e = null;
		ConfigureData conf = null;
		List configs = new ArrayList();

		while (es.hasMoreElements()) {
			e = es.nextElement();
			conf = new ConfigureData();
			String conf_id = (String) e;
			String conf_value = props.getProperty(conf_id);
			conf.setConf_id(conf_id);
			conf.setConf_value(conf_value);
			configs.add(conf);
		}

		return configs;
	}

	public List<ConfigureData> getConfigures(String confFile) {
		if (this.confs.get(confFile) != null) {
			return getProperties((Properties) this.confs.get(confFile));
		}

		Properties props = null;
		props = new Properties();
		InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(confFile);
		try {
			props.load(stream);
		} catch (IOException e) {
			throw new CustomRuntimeException(CustomErrorCode.ERROR_RESOURCE_IS_NOT_READY, e);
		}

		this.confs.put(confFile, props);

		return getProperties(props);
	}

	public List<ConfigureData> getConfigures() {
		return null;
	}

	public Properties getPConfigures(String confFile) {
		if (this.confs.get(confFile) != null) {
			return ((Properties) this.confs.get(confFile));
		}
		getConfigures(confFile);
		return ((Properties) this.confs.get(confFile));
	}
}
