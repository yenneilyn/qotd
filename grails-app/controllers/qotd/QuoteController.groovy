package qotd

class QuoteController {
    static scaffold = true

    def index() {
        redirect(action: random)
    }

    def random = {
       def allQuotes = Quote.list()
        def randomQuote
        if (allQuotes.size() > 0) {
            def randomIdx = new Random().nextInt(allQuotes.size())
            randomQuote = allQuotes[randomIdx]
        }
        else{
            randomQuote = new qotd.Quote(author: "Anonymous", content: "Real Programmers Don't eat Quiche")
        }
        [quote : randomQuote]
    }
}
