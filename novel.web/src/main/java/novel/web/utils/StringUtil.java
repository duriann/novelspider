package novel.web.utils;

import java.util.Iterator;
import java.util.List;

public class StringUtil {
    public StringUtil() {
    }

    public static <T extends Enum<T>> T toEnum(String str, Class<T> enumType, T defaultValue) {
        return toEnum(str, enumType, defaultValue, true);
    }

    public static <T extends Enum<T>> T toEnum(String str, Class<T> enumType, T defaultValue, boolean ignoreCase) {
        if (str != null && !str.isEmpty()) {
            try {
                if (ignoreCase) {
                    str = str.toUpperCase();
                }

                return Enum.valueOf(enumType, str);
            } catch (RuntimeException var5) {
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
    }

    public static boolean isNullOrEmpty(String val) {
        return val == null || val.isEmpty();
    }

    public static boolean toBoolean(String source, boolean defaultValue) {
        if (!isNullOrEmpty(source)) {
            try {
                return Boolean.valueOf(source);
            } catch (Exception var3) {
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
    }

    public static Integer toInteger(String source) {
        return toInteger(source, -1);
    }

    public static Integer toInteger(String source, Integer defaultValue) {
        if (source != null && !source.isEmpty()) {
            try {
                return Integer.parseInt(source);
            } catch (Exception var3) {
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
    }

    public static long toInt64(String source) {
        return toInt64(source, -1L);
    }

    public static long toInt64(String source, long defaultValue) {
        if (source != null && !source.isEmpty()) {
            try {
                return Long.parseLong(source);
            } catch (Exception var4) {
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
    }

    public static String listIntegerToString(List<Integer> stringList) {
        if (stringList == null) {
            return null;
        } else {
            StringBuilder result = new StringBuilder();
            boolean flag = false;

            Integer string;
            for(Iterator var3 = stringList.iterator(); var3.hasNext(); result.append(string)) {
                string = (Integer)var3.next();
                if (flag) {
                    result.append(",");
                } else {
                    flag = true;
                }
            }

            return result.toString();
        }
    }

    public static String listLongToString(List<Long> stringList) {
        if (stringList == null) {
            return null;
        } else {
            StringBuilder result = new StringBuilder();
            boolean flag = false;

            Long string;
            for(Iterator var3 = stringList.iterator(); var3.hasNext(); result.append(string)) {
                string = (Long)var3.next();
                if (flag) {
                    result.append(",");
                } else {
                    flag = true;
                }
            }

            return result.toString();
        }
    }

    public static String listToString(List<String> stringList) {
        if (stringList == null) {
            return null;
        } else {
            StringBuilder result = new StringBuilder();
            boolean flag = false;

            String string;
            for(Iterator var3 = stringList.iterator(); var3.hasNext(); result.append(string)) {
                string = (String)var3.next();
                if (flag) {
                    result.append(",");
                } else {
                    flag = true;
                }
            }

            return result.toString();
        }
    }

    public static String change2MysqlUtf8(String content) {
        if (content != null && !content.isEmpty()) {
            StringBuffer response = new StringBuffer(256);

            while(true) {
                int codeIndex = getUnicodeSupportForMysqlUtf8(content, 0);
                int begin = content.offsetByCodePoints(0, codeIndex);
                response.append(content.substring(0, begin));
                if (begin + 1 >= content.length()) {
                    break;
                }

                int end = content.offsetByCodePoints(0, codeIndex + 1);
                if (end == -1) {
                    break;
                }

                content = content.substring(end);
            }

            return response.toString();
        } else {
            return "";
        }
    }

    private static int getUnicodeSupportForMysqlUtf8(String content, int startIndex) {
        int count = content.codePointCount(startIndex, content.length());

        int i;
        for(i = 0; i < count; ++i) {
            int c = content.codePointAt(i);
            if (c < 0 || c > 65535) {
                return i;
            }
        }

        return i - 1;
    }
}
