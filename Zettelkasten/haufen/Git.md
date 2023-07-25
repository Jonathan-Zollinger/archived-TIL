https://www.conventionalcommits.org/en/v1.0.0/#summary

remove a git merge message from history 
https://stackoverflow.com/questions/17577409/git-remove-merge-commit-from-history/48604371#48604371

```bash
git rebase --onto <commit I want to use> <default merge commit>
```

```mermaid
gitGraph
       commit id: "1"
       commit id: "2"
       branch nice_feature
       checkout nice_feature
       commit id: "3"
       checkout main
       commit id: "4"
       checkout nice_feature
       branch very_nice_feature
       checkout very_nice_feature
       commit id: "5"
       checkout main
       commit id: "6"
       checkout nice_feature
       commit id: "7"
       checkout main
       merge nice_feature id: "PR #456"
       checkout very_nice_feature
       merge main id: "default merge commit"
       commit id: "commit I want to use"
       checkout main
       commit id: "9"
```