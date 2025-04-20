class Solution {
    Map<String, String> nodes;
    Map<String, Map<String, Double>> cost;

    class Node {
        String node;
        double cost;
        Node(String _node, double _cost) {
            node = _node;
            cost = _cost;
        }
    }

    public void create(String node) {
        nodes.putIfAbsent(node, node);
        cost.putIfAbsent(node, new HashMap<>());
        cost.get(node).put(node, 1.0);
    }

    public Node find(String node) {
        if(nodes.get(node).equals(node)) {
            return new Node(node, 1.0);
        }
        Node par = find(nodes.get(node));
        double price = cost.get(node).get(nodes.get(node));
        nodes.put(node, par.node);
        cost.get(node).put(par.node, par.cost * price);
        return new Node(par.node, par.cost * price);
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        cost = new HashMap<>();
        nodes = new HashMap<>();
        int k = 0;
        for(var eqn : equations) {
            create(eqn.get(0));
            create(eqn.get(1));
            Node u = find(eqn.get(0)), v = find(eqn.get(1));
            double price = v.cost/u.cost * values[k];
            nodes.put(u.node, v.node);            
            cost.get(u.node).put(v.node, price);
            cost.get(v.node).put(u.node, 1.0 / price);
            k++;
        }
        k = 0;
        double ans[] = new double[queries.size()];
        for(var query : queries) {
            if(nodes.containsKey(query.get(0)) 
                    && nodes.containsKey(query.get(1))) {
                Node u = find(query.get(0)), v = find(query.get(1));
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