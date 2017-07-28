/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frommikesdesk.resteasy.app;

/**
 *
 * @author Michael Silveus <michaelsilveus@gmail.com>
 */
public class Helper {
    public static String getSystemFolder(String rootpath, String path) {
        StringBuffer fullpath = new StringBuffer();
        
        if (isLinux()) {
            //linux
            fullpath.append("/var/log/");
            fullpath.append(rootpath);
            fullpath.append("/");
            fullpath.append(path);
            fullpath.append("/");
        } else {
            //windows
            fullpath.append(java.lang.System.getProperty("user.home").toLowerCase());
            fullpath.append("\\");
            fullpath.append(rootpath);
            fullpath.append("\\");
            fullpath.append(path);
            fullpath.append("\\");
        }
        
        
        return fullpath.toString();
    }
    public static boolean isLinux() {
        String os = System.getProperty("os.name").toLowerCase();
        return (os != null && os.indexOf("linux") != -1);
    }
}
