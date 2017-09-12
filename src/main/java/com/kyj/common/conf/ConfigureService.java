package com.kyj.common.conf;

import java.util.List;
import java.util.Properties;

public abstract interface ConfigureService
{
  public abstract void init(String paramString)
    throws Exception;

  public abstract ConfigureData getConfigure(String paramString1, String paramString2);

  public abstract List<ConfigureData> getConfigures(String paramString);

  public abstract Properties getPConfigures(String paramString);

  public abstract List<ConfigureData> getConfigures();
}
