/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicornballaz.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Joel
 */
@Entity
@Table(name = "REVIEWS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reviews.findAll", query = "SELECT r FROM Reviews r"),
    @NamedQuery(name = "Reviews.findByReviewid", query = "SELECT r FROM Reviews r WHERE r.reviewid = :reviewid"),
    @NamedQuery(name = "Reviews.findByProductid", query = "SELECT r FROM Reviews r WHERE r.productid = :productid"),
    @NamedQuery(name = "Reviews.findByUserid", query = "SELECT r FROM Reviews r WHERE r.userid = :userid"),
    @NamedQuery(name = "Reviews.findByRanking", query = "SELECT r FROM Reviews r WHERE r.ranking = :ranking"),
    @NamedQuery(name = "Reviews.findByReviewheadline", query = "SELECT r FROM Reviews r WHERE r.reviewheadline = :reviewheadline"),
    @NamedQuery(name = "Reviews.findByReview", query = "SELECT r FROM Reviews r WHERE r.review = :review")})
public class Reviews implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "REVIEWID")
    private Integer reviewid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "PRODUCTID")
    private String productid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USERID")
    private int userid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RANKING")
    private int ranking;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "REVIEWHEADLINE")
    private String reviewheadline;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "REVIEW")
    private String review;

    public Reviews() {
    }

    public Reviews(Integer reviewid) {
        this.reviewid = reviewid;
    }

    public Reviews(Integer reviewid, String productid, int userid, int ranking, String reviewheadline, String review) {
        this.reviewid = reviewid;
        this.productid = productid;
        this.userid = userid;
        this.ranking = ranking;
        this.reviewheadline = reviewheadline;
        this.review = review;
    }

    public Integer getReviewid() {
        return reviewid;
    }

    public void setReviewid(Integer reviewid) {
        this.reviewid = reviewid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getReviewheadline() {
        return reviewheadline;
    }

    public void setReviewheadline(String reviewheadline) {
        this.reviewheadline = reviewheadline;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewid != null ? reviewid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reviews)) {
            return false;
        }
        Reviews other = (Reviews) object;
        if ((this.reviewid == null && other.reviewid != null) || (this.reviewid != null && !this.reviewid.equals(other.reviewid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unicornballaz.model.Reviews[ reviewid=" + reviewid + " ]";
    }
    
}
