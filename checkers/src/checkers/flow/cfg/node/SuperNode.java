package checkers.flow.cfg.node;

import java.util.Collection;
import java.util.Collections;

import checkers.flow.util.HashCodeUtils;

import com.sun.source.tree.IdentifierTree;
import com.sun.source.tree.Tree;

/**
 * A node for a reference to 'super'.
 * 
 * <pre>
 *   <em>this</em>
 * </pre>
 * 
 * @author Stefan Heule
 * @author Charlie Garrett
 * 
 */
public class SuperNode extends Node {

	protected Tree tree;

	public SuperNode(Tree t) {
		assert t instanceof IdentifierTree &&
			((IdentifierTree)t).getName().equals("super");
		tree = t;
	}

	@Override
	public Tree getTree() {
		return tree;
	}

	@Override
	public <R, P> R accept(NodeVisitor<R, P> visitor, P p) {
		return visitor.visitSuper(this, p);
	}

	public String getName() {
		return "super";
	}

	@Override
	public String toString() {
		return getName();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof SuperNode)) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return HashCodeUtils.hash(getName());
	}

	@Override
	public Collection<Node> getOperands() {
		return Collections.emptyList();
	}
}
