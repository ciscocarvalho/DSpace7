/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.eperson;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.proxy.HibernateProxyHelper;

/**
 * Database entity representation of the group2groupcache table
 *
 * @author kevinvandevelde at atmire.com
 */
@Entity
@Table(name = "group2groupcache", uniqueConstraints = { @UniqueConstraint(columnNames = {"parent_id", "child_id"}) })
public class Group2GroupCache implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id", nullable = false)
    public Group parent;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "child_id", nullable = false)
    public Group child;

    public Group getParent() {
        return parent;
    }

    public void setParent(Group parent) {
        this.parent = parent;
    }

    public Group getChild() {
        return child;
    }

    public void setChild(Group child) {
        this.child = child;
    }

    /**
     * Protected constructor, create object using:
     * {@link org.dspace.eperson.service.GroupService}
     */
    protected Group2GroupCache() {

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Class<?> objClass = HibernateProxyHelper.getClassWithoutInitializingProxy(obj);
        if (getClass() != objClass) {
            return false;
        }
        final Group2GroupCache other = (Group2GroupCache) obj;
        if (!parent.equals(other.getParent())) {
            return false;
        }
        if (!child.equals(other.getChild())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder()
            .append(parent == null ? "" : parent.getID())
            .append(child == null ? "" : child.getID())
            .toHashCode();
    }
}
