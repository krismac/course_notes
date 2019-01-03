import React from "react";

const Comment = ({children, author}) => (
  <div className="comment">
    <h4>{children}</h4>
    <p>{author}</p>
  </div>
);

export default Comment;
