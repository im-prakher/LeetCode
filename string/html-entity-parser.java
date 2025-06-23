class Solution {
    public String entityParser(String text) {
        Map<String, String> map = new HashMap<>();
        text = text.replace("&gt;", ">");
        text = text.replace("&quot;", "\"");
        text = text.replace("&apos;", "'");
        text = text.replace("&lt;", "<");
        text = text.replace("&frasl;", "/");
        text = text.replace("&amp;", "&");
        return text;
    }
}