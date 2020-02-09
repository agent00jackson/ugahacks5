from finviz.screener import Screener

filters = ['idx_sp500']
stonks = Screener(filters=filters, order='price')

ret = []
for s in stonks:
    print(s)
    #grab company name
    #grab wikipedia description
    #grab picture url
    #create tuple (ticker, name, desc, picture url)
    #add tuple to companyStack