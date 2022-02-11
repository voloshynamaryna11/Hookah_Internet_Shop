// Burger menu
const iconMenu = document.querySelector('.menu__icon')
const menuBody = document.querySelector('.menu__body')
const cartBtn = document.querySelectorAll('.cart')

iconMenu.addEventListener('click', e => {
    document.body.classList.toggle('_lock')
    iconMenu.classList.toggle('_active')
    menuBody.classList.toggle('_active')
})


// Date modification
const orderDate = document.querySelectorAll('.date-value')

orderDate.forEach(dateItem => {
    let date = dateItem.innerHTML.split('T')
    dateItem.innerHTML = `${date[0]} | ${date[1]}`
})


// Product amount zero
const productAmount = document.querySelectorAll('.product__amount')

productAmount.forEach( elem => {
    if (elem.innerHTML === '0') {
        product = elem.parentElement.parentElement
        product.classList.add('out-of-stock')
    }
})


// List drop down function
const dropDownList = (clickBtn, dropDown) => {
    clickBtn.forEach((btn, index) => {
        btn.addEventListener('click', e => {
            e.preventDefault()

            dropDown[index].classList.toggle('open')
        })
    })
}


// User list: open note
const userOpenBtn = document.querySelectorAll('.ads_click-btn')
const dropDownUser = document.querySelectorAll('.user-info__container')

dropDownList(userOpenBtn, dropDownUser)

// Product list: open note
const productOpenBtn = document.querySelectorAll('.admin-products_click-btn')
const dropDownProduct = document.querySelectorAll('.admin-product-info__container')

dropDownList(productOpenBtn, dropDownProduct)

// Order list: open note
const orderOpenBtn = document.querySelectorAll('.admin-order_click-btn')
const dropDownOrder = document.querySelectorAll('.admin-order-info__container')

dropDownList(orderOpenBtn, dropDownOrder)