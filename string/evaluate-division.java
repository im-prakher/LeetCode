class Solution {
    class Node {
        String node;
        double cost;
        Node(String _node, double _cost) {
            node = _node;
            cost = _cost;
        }
    }
    public Node find(Map<String, String> nodes, Map<String, Map<String, Double>> cost, String node) {
        if(nodes.get(node).equals(node)) {
            return new Node(node, 1.0);
        }
        Node par = find(nodes, cost, nodes.get(node));
        double price = cost.get(node).get(nodes.get(node));
        nodes.put(node, par.node);
        cost.get(node).put(par.node, par.cost * price);
        return new Node(par.node, par.cost * price);
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> cost = new HashMap<>();
        Map<String, String> nodes = new HashMap<>();
        int k = 0;
        for(var eqn : equations) {
            nodes.putIfAbsent(eqn.get(0), eqn.get(0));
            cost.putIfAbsent(eqn.get(0), new HashMap<>());
            cost.get(eqn.get(0)).put(eqn.get(0), 1.0);
            nodes.putIfAbsent(eqn.get(1), eqn.get(1));
            cost.putIfAbsent(eqn.get(1), new HashMap<>());
            cost.get(eqn.get(1)).put(eqn.get(1), 1.0);
            Node u = find(nodes, cost, eqn.get(0)), 
                 v = find(nodes, cost, eqn.get(1));
            double price = v.cost/u.cost * values[k];
            nodes.put(u.node, v.node);            
            cost.get(u.node).put(v.node, price);
            cost.putIfAbsent(v.node, new HashMap<>());
            cost.get(v.node).put(u.node, 1.0 / price);
            k++;
        }
        k = 0;
        double ans[] = new double[queries.size()];
        for(var query : queries) {
            if(nodes.containsKey(query.get(0)) 
                    && nodes.containsKey(query.get(1))) {
                Node u = find(nodes, cost, query.get(0)), 
                      v = find(nodes, cost, query.get(1));
                if(u.node.equals(v.node)) 
                    ans[k] = u.cost / v.cost;
                else
                    ans[k] = -1.0;
            }
            else
                ans[k] = -1.0;
            k++;
        }
        return ans;
    }
}