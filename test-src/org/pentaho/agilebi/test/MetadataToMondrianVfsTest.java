package org.pentaho.agilebi.test;

import java.io.InputStream;

import junit.framework.Assert;

import org.apache.commons.vfs.FileObject;
import org.apache.commons.vfs.FileSystemManager;
import org.apache.commons.vfs.VFS;
import org.junit.Test;

@SuppressWarnings("nls")
public class MetadataToMondrianVfsTest {
  
  @Test
  public void testVfs() throws Exception {
    FileSystemManager fsManager = VFS.getManager();
    FileObject fobj = fsManager.resolveFile("mtm:test-res/example_olap.xmi");
    StringBuilder buf = new StringBuilder(1000);
    InputStream in = fobj.getContent().getInputStream();
    int n;
    while ((n = in.read()) != -1) {
        buf.append((char) n);
    }
    in.close();
    String results = buf.toString();
    Assert.assertTrue(results.indexOf("<Cube name=\"customer2 Table\">") >= 0);
  }
}