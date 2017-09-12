package com.kyj.common.utils;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtils
{
  private static final int CONNECT_TIMEOUT_VALUE = 20000;
  private static final int SOCKET_TIMEOUT_VALUE = 60000;
  private static RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(20000).setSocketTimeout(60000).build();

  private static ResponseHandler<String> responseHandler = new ResponseHandler() {
    public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
      int status = response.getStatusLine().getStatusCode();
      if ((status >= 200) && (status < 300)) {
        HttpEntity entity = response.getEntity();
        return ((entity != null) ? EntityUtils.toString(entity, "UTF-8") : null);
      }
      throw new ClientProtocolException("request failed,unexpected response status: " + status);
    }
  };

  public static String postJSON(String url, Object sendData)
    throws Exception
  {
    HttpPost httppost = new HttpPost(url);
    httppost.setConfig(requestConfig);
    StringEntity entity = new StringEntity(JSONUtils.convertObject2Json(sendData), ContentType.create("application/json", "UTF-8"));

    httppost.setEntity(entity);
    CloseableHttpClient httpClient = null;
    String responseBody = null;
    try {
      httpClient = HttpClients.createDefault();
      responseBody = (String)httpClient.execute(httppost, responseHandler);
    } finally {
      if (httpClient != null) {
        httpClient.close();
      }
    }
    return responseBody;
  }

  public static String post(String url, Map<String, String> params)
    throws Exception
  {
    List nvps = new ArrayList();
    if (params != null) {
      Set<Entry<String, String>> entrySet = params.entrySet();
      for (Entry entry : entrySet) {
        nvps.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue()));
      }
    }

    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nvps, "UTF-8");
    HttpPost httppost = new HttpPost(url);
    httppost.setConfig(requestConfig);
    httppost.setEntity(entity);
    CloseableHttpClient httpClient = null;
    String responseBody = null;
    try {
      httpClient = HttpClients.createDefault();
      responseBody = (String)httpClient.execute(httppost, responseHandler);
    } finally {
      if (httpClient != null) {
        httpClient.close();
      }
    }
    return responseBody;
  }

  public static String get(String url)
    throws Exception
  {
    StringBuffer encodedUrl = new StringBuffer();
    if (url.contains("?")) {
      encodedUrl.append(url.substring(0, url.lastIndexOf("?"))).append("?");
      String paramstr = url.substring(url.lastIndexOf("?") + 1);
      String[] params = paramstr.split("&");
      for (String param : params) {
        String pkey = param.substring(0, param.lastIndexOf("="));
        String pvalue = param.substring(param.lastIndexOf("=") + 1);
        encodedUrl.append(pkey).append("=").append(URLEncoder.encode(pvalue, "UTF-8")).append("&");
      }
      String temp = encodedUrl.toString();
      temp.substring(0, temp.lastIndexOf("&"));
      encodedUrl = new StringBuffer(temp);
    } else {
      encodedUrl.append(url);
    }
    HttpGet httpGet = new HttpGet(encodedUrl.toString());
    CloseableHttpClient httpClient = null;
    String responseBody = null;
    try {
      httpClient = HttpClients.createDefault();
      responseBody = (String)httpClient.execute(httpGet, responseHandler);
    } finally {
      if (httpClient != null) {
        httpClient.close();
      }
    }
    return responseBody;
  }
}

/* Location:           D:\software\yunda_jar\yd\foundation\foundation-1.5.0-RELEASE.jar
 * Qualified Name:     com.yd.common.utils.HttpUtils
 * JD-Core Version:    0.5.3
 */