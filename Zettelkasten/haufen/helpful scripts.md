## JAVA
convert vanilla class with record
step 1:
	Search:  `public\sclass\s(\w+)\s\{([^{]+)public(\n?.+\n)+(\n?.?\}?)+`
	Replace: `public record $1($2){}`
step 2:
	