package com.makenv.filter.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by tg on 2015/7/28.
 */
public class InputStreamUtil {
  private static Logger logger = LoggerFactory.getLogger(InputStreamUtil.class);

  public static String inputStream2String(InputStream is) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    StringBuilder sb = new StringBuilder();
    String line;

    try {
      while ((line = reader.readLine()) != null) {
        sb.append(line);
      }
      reader.close();
    } catch (IOException e) {
      logger.error("inputStream2String error" + e);
    }

    return sb.toString();
  }

  public static String request2String(ServletRequest request) throws IOException {
    StringBuilder sb = new StringBuilder();
    try (InputStream inputStream = request.getInputStream();
         BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")))) {
      String line;
      while ((line = reader.readLine()) != null) {
        sb.append(line);
      }
    }
    return sb.toString();
  }
}
