awk -F\\t -vq="'" 'function quote(token) { gsub(q, "\\"q, token); return q token q } { print quote($2) "(" quote($3) ", " quote($1) ")" }' filename
