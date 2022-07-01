package ls.comm;

/**
 * @author dlins
 */
public interface Option<K, V> {
    /**
     * 获取选项的码值
     *
     * @return code
     */
    K getCode();

    /**
     * 获取选项的文本
     *
     * @return text
     */
    V getText();

}
