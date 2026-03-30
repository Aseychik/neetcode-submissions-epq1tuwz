class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(Integer.toString(strs.size()));
        sb.append("_");

        for (String s : strs) {
            sb.append(Integer.toString(s.length()));
            sb.append("_");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> arr = new ArrayList<>();
        
        int idx = str.indexOf('_');
        int count = Integer.parseInt(str.substring(0, idx));
        
        int start = idx + 1, underscoreIdx, length;
        String s;

        for (int i = 0; i < count; i++) {
            underscoreIdx = str.indexOf('_', start);
            length = Integer.parseInt(str.substring(start, underscoreIdx));
            
            start = underscoreIdx + 1;
            s = str.substring(start, start + length);
            arr.add(s);
            
            start += length;
        }
        
        return arr;
    }
}
