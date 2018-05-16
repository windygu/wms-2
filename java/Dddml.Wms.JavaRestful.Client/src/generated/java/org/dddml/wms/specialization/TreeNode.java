package org.dddml.wms.specialization;

public interface TreeNode<T>
{
    T getContent();

    Iterable<TreeNode<T>> getChildren();
}
