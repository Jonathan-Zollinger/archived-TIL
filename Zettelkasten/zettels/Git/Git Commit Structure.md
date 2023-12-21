## git commit messages
#### Sources
[angular contributing page (ultimate syntax source)](https://github.com/angular/angular/blob/22b96b9/CONTRIBUTING.md#-commit-message-guidelines) [conventional commits](https://www.conventionalcommits.org/en/v1.0.0/#specification)

### Syntax
```typescript
<type>(<scope>): <subject>
<BLANK LINE>
<body>
<BLANK LINE>
<footer>
```


<h4>Type</h4>
	<table>
	<caption align="left">Type must be one of the following</caption>
	<thead>
	  <tr>
	    <th>type</th>
	    <th>Description</th>
	  </tr>
	</thead>
	<tbody>
	  <tr>
	    <td>build</td>
	    <td>Changes that affect the build system or external dependencies (example scopes: gulp, broccoli, npm)</td>
	  </tr>
	  <tr>
	    <td>ci</td>
	    <td> Changes to our CI configuration files and scripts (example scopes:&nbsp;&nbsp;Travis, Circle, BrowserStack, SauceLabs)</td>
	  </tr>
	  <tr>
	    <td>docs</td>
	    <td> Documentation only changes</td>
	  </tr>
	  <tr>
	    <td>feat</td>
	    <td> A new feature</td>
	  </tr>
	  <tr>
	    <td>fix</td>
	    <td> A bug fix</td>
	  </tr>
	  <tr>
	    <td>perf</td>
	    <td> A code change that improves performance</td>
	  </tr>
	  <tr>
	    <td>refactor</td>
	    <td> A code change that neither fixes a bug nor adds a feature</td>
	  </tr>
	  <tr>
	    <td>style</td>
	    <td> Changes that do not affect the meaning of the code (white-space, formatting, missing semi-colons, etc)</td>
	  </tr>
	  <tr>
	    <td>test</td>
	    <td> Adding missing tests or correcting existing tests</td>
	  </tr>
	</tbody>
	</table>

#### Subject

The subject contains a succinct description of the change:

- use the imperative, present tense: "change" not "changed" nor "changes"
- don't capitalize the first letter
- no dot (.) at the end

#### Body

Just as in the **subject**, use the imperative, present tense: "change" not "changed" nor "changes". The body should include the motivation for the change and contrast this with previous behavior.

#### Footer

The footer should contain any information about **Breaking Changes** and is also the place to reference GitHub issues that this commit **Closes**.

**Breaking Changes** should start with the word `BREAKING CHANGE:` with a space or two newlines. The rest of the commit message is then used for this.