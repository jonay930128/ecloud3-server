package com.makenv.filter;




import com.makenv.filter.util.InputStreamUtil;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by TG on 2015/7/24.
 */
public class RequestWrapper extends HttpServletRequestWrapper {

  private final byte[] body;

  public RequestWrapper(HttpServletRequest request) throws IOException {
    super(request);
    body =  InputStreamUtil.request2String(request).getBytes(Charset.forName("UTF-8"));
  }

  @Override
  public BufferedReader getReader() throws IOException {
    return new BufferedReader(new InputStreamReader(getInputStream()));
  }

  @Override
  public ServletInputStream getInputStream() throws IOException {

    final ByteArrayInputStream bais = new ByteArrayInputStream(body);

    return new ServletInputStream() {

      @Override
      public int read() throws IOException {
        return bais.read();
      }

      @Override
      public boolean isFinished() {
        return false;
      }

      @Override
      public boolean isReady() {
        return false;
      }

      @Override
      public void setReadListener(ReadListener readListener) {

      }
    };
  }
}
