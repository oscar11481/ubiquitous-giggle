package efia.test0112.entity;

import java.util.Map;

public class PageBean {
    public static final String DEFAULT_PAGE_ID = "pageBean";
    public static final int DEFAULT_PAGE = 1;
    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final String PARAM_OFFSET = "offset";
    public static final String PARAM_PAGE = "page";
    public static final String PARAM_PAGESIZE = "pageSize";
    public static final String PARAM_COUNT = "count";
    public static final String PARAM_ORDERBY = "orderBy";
    public static final String PARAM_ORDER = "order";
    
    // private static URLCodec codec = new URLCodec();
    
    private String pageId;
    private Integer page;   // 第幾頁
    private Integer pageSize; // 每頁大小
    private Integer count; // 總共筆數
    private String actionUrl;
    private String orderBy;
    private String order;
    
    private Map<String, Object> params;
    
    
    public PageBean() {
        this(DEFAULT_PAGE_ID);
    }
    
    public PageBean(String pageId) {
        this(pageId, null, null);
    }
    
    public PageBean(Integer page, Integer pageSize) {
        this(DEFAULT_PAGE_ID, page, pageSize);
    }
    
    public PageBean(String pageId, Integer page, Integer pageSize) {
        this(pageId, page, pageSize, null);
    }
    
    public PageBean(String pageId, Integer page, Integer pageSize, Integer count) {
        super();
        this.pageId = pageId;
        this.page = page;
        this.pageSize = pageSize;
        this.count = count;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public Integer getPage() {
        if (page == null) {
            return null;
        }
        if (count == null) {
            return DEFAULT_PAGE;
        }
        return (page > getTotalPage()) ? DEFAULT_PAGE : page;
    }
    
    public void setPage(Integer page) {
        this.page = page;
    }
    
    public Integer getPageSize() {
        return pageSize;
    }
    
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
       
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
        
    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getFirstPage() {
        return DEFAULT_PAGE;
    }
    
    public int getPrevPage() {
        if (page == null) {
            return DEFAULT_PAGE;
        }
        return (page >  1) ? (page - 1) : DEFAULT_PAGE;
    }
    
    public int getNextPage() {
        if ((page == null) || (count == null) || (count == 0)) {
            return DEFAULT_PAGE;
        }
        return (page < getTotalPage()) ? (page + 1) : getTotalPage();
    }
    
    public int getLastPage() {
        if ((page == null) || (count == null) || (count == 0)) {
            return DEFAULT_PAGE;
        }
        return getTotalPage();
    }
    
    /**
     * 總共頁數
     * @return
     */
    public int getTotalPage() {
        return (int) Math.ceil((double) count / pageSize);
    }
    
    /**
     * 當前頁數起始位置
     * @return
     */
    public int getOffset() {
        return (getPage() - 1) * pageSize;
    }
    
    public int getStart() {
        int start = getOffset() + 1;
        return (start < count) ? start : count;
    }
    
    public int getEnd() {
        int end = getPage() * getPageSize();
        return (end < this.count) ? end : count;
    }

    @Override
    public String toString() {
        return "PageBean [pageId=" + pageId + ", page=" + page + ", pageSize=" + pageSize + ", count=" + count
                + ", actionUrl=" + actionUrl + ", orderBy=" + orderBy + ", order=" + order + "]";
    }    
    
    
}
