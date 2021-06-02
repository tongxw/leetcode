import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * @lc app=leetcode id=811 lang=java
 *
 * [811] Subdomain Visit Count
 */

// @lc code=start
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> countMap = new HashMap<>(); // { domain : count }
        for (String cpdomain : cpdomains) {
            // String[] tokens = cpdomain.split("[ .]+");
            String[] countAndDomain = cpdomain.split(" ");
            if (countAndDomain.length != 2) {
                continue;
            }

            int count = Integer.parseInt(countAndDomain[0]);
            String domain = countAndDomain[1];
            countMap.put(domain, countMap.getOrDefault(domain, 0) + count);

            // String[] subDomains = domain.split("\\.");
            // if (subDomains.length == 1) {
            //     continue;
            // } else if (subDomains.length == 2) {
            //     countMap.put(subDomains[1], countMap.getOrDefault(subDomains[1], 0) + count);
            // } else if (subDomains.length == 3) {
            //     countMap.put(subDomains[2], countMap.getOrDefault(subDomains[2], 0) + count);
            //     countMap.put(subDomains[1] + "." + subDomains[2], countMap.getOrDefault(subDomains[1] + "." + subDomains[2] , 0) + count);
            // }
            for (int i=0; i<domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    String subDomain = domain.substring(i+1, domain.length());
                    countMap.put(subDomain, countMap.getOrDefault(subDomain, 0) + count);
                }
            }
        }

        List<String> ret = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            String countAndDomain = entry.getValue() + " " + entry.getKey();
            ret.add(countAndDomain);
        }

        return ret;
        
    }
}
// @lc code=end

