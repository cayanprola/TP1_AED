Getting the data
----------------

https://github.com/maxharlow/tutorials/tree/master/find-connections-with-fuzzy-matching


Exact matches
-------------

    $ fuzzy-join \
        --filename1=forbes-billionaires.csv \
        --filename2=forbes-china-billionaires.csv \
        --name1=name \
        --name2=name


Fuzzy matching
-------------------------

    $ fuzzy-join \
	    --filename1=cia-world-leaders.csv \
	    --filename2=white-house-visitors.csv \
	    --name1=leader_name \
	    --name2=visitor_name \
	    --distance=levenshtein


Fuzzy algorithm #1: Levenshtein
-------------------------------

    $ fuzzy-join \
	    --filename1=cia-world-leaders.csv \
	    --filename2=forbes-china-billionaires.csv \
	    --name1=leader_name \
	    --name2=name \
	    --distance=levenshtein \
	    > billionaire-chinese-leaders.csv


Fuzzy algorithm #2: Metaphone
-----------------------------

    $ fuzzy-join \
	    --filename1=cia-world-leaders.csv \
	    --filename2=un-sanctions.csv \
	    --name1=leader_name \
	    --name2=name \
	    --distance=metaphone \
	    > sanctioned-leaders.csv

Fuzzy algorithm #3: Bilenko
---------------------------

    $ fuzzy-join \
	    --filename1=cia-world-leaders.csv \
	    --filename2=white-house-visitors.csv \
	    --name1=leader_name \
	    --name2=visitor_name \
	    --distance=bilenko \
	    > leaders-visiting-trump-3.csv

