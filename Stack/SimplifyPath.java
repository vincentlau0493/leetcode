public class SimplifyPath {


	public String simplifyPath(String path) {

		String[] pathArray = path.split("\\/");
		Stack<String> stack = new Stack<>();

		for (int i=0; i<pathArray.length; i++) {
			String p = pathArray[i];
			if (p.equals("") || p.equals(".")) continue;

			if (p.equals("..")) {
				if (!stack.isEmpty()) stack.pop();
			} else {
				stack.push(p);
			}
		}

		String res = "";
		while (!stack.isEmpty()) {
			res = "/"  + stack.pop() + res;
		}

		return res.equals("") ? "/" : res;
	}


}