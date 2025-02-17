class Solution {
    Map<String, List<String>> adj;
    Set<String> sup;
    List<String> ans;
    Set<String> vis;
    public void dfs(String recipe) {
        vis.add(recipe);
        for(String ing : adj.get(recipe)) {
            if(sup.contains(ing) || vis.contains(ing))
                continue;
            else if(adj.containsKey(ing))
                dfs(ing);
            else
                return;
        }
        ans.add(recipe);
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
    adj = new HashMap<>();
    vis = new HashSet<>();
    sup = new HashSet<>();
    ans = new ArrayList<>();
    for(int i = 0; i < recipes.length; i++) {   
        adj.put(recipes[i], new ArrayList<>());  
        for(String ing : ingredients.get(i)) {
            adj.get(recipes[i]).add(ing);
        }
    }
    for(String supply : supplies) 
        sup.add(supply);
    for(String recipe : recipes) {
        if(!vis.contains(recipe))
            dfs(recipe);
    } 
    return ans;
}
}