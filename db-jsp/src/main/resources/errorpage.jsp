<%@ page import="java.util.Arrays"%><%@ page contentType="application/json; charset=UTF-8" %>
<%@ page isErrorPage="true" %>
<%="{\"errMsg\":" + "\"" + exception.getMessage() + "\", " +
 "\"errCause\":" + "\"" + exception.getCause() + "\"," +
 "\"errTrace\":" + "\"" + Arrays.toString(exception.getStackTrace()) + "\"," +
  "\"errLocalizedMessage\":" + "\"" + exception.getLocalizedMessage() + "\"," +
  "\"errSuppressed\":" + "\"" + Arrays.toString(exception.getSuppressed()) + "\"," +
  "\"errClass\":" + "\"" + exception.getClass() + "\"," +
  "\"time\":" +  "\"" + java.util.Calendar.getInstance().getTime() + "\"}"%>
